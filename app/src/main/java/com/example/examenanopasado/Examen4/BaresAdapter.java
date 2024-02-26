package com.example.examenanopasado.Examen4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.examenanopasado.Examen4.Bares;
import com.example.examenanopasado.Examen4.BaresAdapter;
import com.example.examenanopasado.R;

import java.util.ArrayList;

public class BaresAdapter extends RecyclerView.Adapter<BaresAdapter.ViewHolder>{
    private ArrayList<Bares> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, Bares unBar);
    }

    private BaresAdapter.ItemClickListener clickListener;

    public void setClickListener(BaresAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView e4tvNombre;

        private final TextView e4tvEstrellas;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            e4tvNombre = (TextView) view.findViewById(R.id.e4tvNombre);
            e4tvEstrellas = (TextView) view.findViewById(R.id.e4tvEstrellas);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre, String estrellas) {
            e4tvNombre.setText(nombre);
            e4tvEstrellas.setText(estrellas);
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
    public BaresAdapter(ArrayList<Bares> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BaresAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_bares, viewGroup, false);

        return new BaresAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BaresAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Bares unBar = datos.get(position);
        viewHolder.setInfo(unBar.getNombre(), String.valueOf(unBar.getEstrellas()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setBares(ArrayList<Bares> bares){
        datos.clear();
        datos.addAll(bares);
        notifyDataSetChanged();
    }
}
