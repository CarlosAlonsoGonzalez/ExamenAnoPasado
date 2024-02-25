package com.example.examenanopasado.Examen1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.examenanopasado.R;

import java.util.ArrayList;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.ViewHolder> {

    private ArrayList<Pelicula> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, Pelicula unaPelicula);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvNombre;
        private final TextView tvDescripcion;
        private final TextView tvEstrellas;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvNombre = (TextView) view.findViewById(R.id.tvNombre);
            tvDescripcion = (TextView) view.findViewById(R.id.tvDescripcion);
            tvEstrellas = (TextView) view.findViewById(R.id.tvEstrellas);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre, String descripcion, String estrellas) {
            tvNombre.setText(nombre);
            tvDescripcion.setText(descripcion);
            tvEstrellas.setText(estrellas);
        }

        @Override
        public void onClick(View view) {
            // Si tengo un manejador de evento lo propago con el índice
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition(), datos.get(getAdapterPosition()));
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data_RickAndMorty to populate views to be used
     * by RecyclerView.
     */
    public PeliculasAdapter(ArrayList<Pelicula> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_peliculas, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Pelicula unaPelicula = datos.get(position);
        viewHolder.setInfo(unaPelicula.getNombre(), unaPelicula.getDescripcion(), String.valueOf(unaPelicula.getEstrellas()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas){
        datos.clear();
        datos.addAll(peliculas);
        notifyDataSetChanged();
    }
}
