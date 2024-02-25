package com.example.examenanopasado.Examen2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.examenanopasado.R;

import java.util.ArrayList;

public class AtraccionesAdapter extends RecyclerView.Adapter<com.example.examenanopasado.Examen2.AtraccionesAdapter.ViewHolder> {

    private ArrayList<Atracciones> datos;

    public interface ItemClickListener {
        void onClick(View view, int position, Atracciones unaAtracciones);
    }

    private com.example.examenanopasado.Examen2.AtraccionesAdapter.ItemClickListener clickListener;

    public void setClickListener(com.example.examenanopasado.Examen2.AtraccionesAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvNombre;
        private final TextView tvDescripcion;
        private final TextView tvOcupantes;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvNombre = (TextView) view.findViewById(R.id.e2tvNombre);
            tvDescripcion = (TextView) view.findViewById(R.id.e2tvDescripcion);
            tvOcupantes = (TextView) view.findViewById(R.id.e2tvOcupantes);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre, String descripcion, String ocupantes) {
            tvNombre.setText(nombre);
            tvDescripcion.setText(descripcion);
            tvOcupantes.setText(ocupantes);
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
    public AtraccionesAdapter(ArrayList<Atracciones> dataSet) {
        datos = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public com.example.examenanopasado.Examen2.AtraccionesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_atracciones, viewGroup, false);

        return new com.example.examenanopasado.Examen2.AtraccionesAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(com.example.examenanopasado.Examen2.AtraccionesAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Atracciones unaAtracciones = datos.get(position);
        viewHolder.setInfo(unaAtracciones.getNombre(), unaAtracciones.getDescripcion(), String.valueOf(unaAtracciones.getOcupantes()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setAtracciones(ArrayList<Atracciones> atracciones){
        datos.clear();
        datos.addAll(atracciones);
        notifyDataSetChanged();
    }
}