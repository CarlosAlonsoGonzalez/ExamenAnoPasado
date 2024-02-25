package com.example.examenanopasado.Examen3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.examenanopasado.Examen3.TPelicula;
import com.example.examenanopasado.Examen3.TPeliculasAdapter;
import com.example.examenanopasado.R;

import java.util.ArrayList;

public class TPeliculasAdapter extends RecyclerView.Adapter<TPeliculasAdapter.ViewHolder>{
    private ArrayList<TPelicula> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, TPelicula unaPelicula);
    }

    private TPeliculasAdapter.ItemClickListener clickListener;

    public void setClickListener(TPeliculasAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView e3tvNombre;
        private final TextView e3tvDescripcion;
        private final TextView e3tvEstrellas;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            e3tvNombre = (TextView) view.findViewById(R.id.e3tvNombre);
            e3tvDescripcion = (TextView) view.findViewById(R.id.e3tvDescripcion);
            e3tvEstrellas = (TextView) view.findViewById(R.id.e3tvEstrellas);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre, String descripcion, String estrellas) {
            e3tvNombre.setText(nombre);
            e3tvDescripcion.setText(descripcion);
            e3tvEstrellas.setText(estrellas);
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
    public TPeliculasAdapter(ArrayList<TPelicula> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TPeliculasAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.trow_peliculas, viewGroup, false);

        return new TPeliculasAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TPeliculasAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        TPelicula unaPelicula = datos.get(position);
        viewHolder.setInfo(unaPelicula.getNombre(), unaPelicula.getDescripcion(), String.valueOf(unaPelicula.getEstrellas()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setTPeliculas(ArrayList<TPelicula> peliculas){
        datos.clear();
        datos.addAll(peliculas);
        notifyDataSetChanged();
    }
}
