package com.example.examenanopasado.Examen2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.examenanopasado.R;

import java.util.ArrayList;

public class MainAtracciones extends AppCompatActivity {

    public static final String INFO_ATRACCIONES = "info de una atraccion";
    RecyclerView rvAtracciones;
    ProgressBar e2pbCargando;
    AtraccionesAdapter atraccionesAdapter;
    private AtraccionesViewModel atraccionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atracciones);

        rvAtracciones = findViewById(R.id.rvAtracciones);
        e2pbCargando = findViewById(R.id.e2pbCargando);
        e2pbCargando.setVisibility(View.VISIBLE);
        rvAtracciones.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        atraccionesAdapter = new AtraccionesAdapter(new ArrayList<>());

        rvAtracciones.setAdapter(atraccionesAdapter);

        // Inicializa y observa los cambios en el ViewModel
        atraccionViewModel = new ViewModelProvider(this).get(AtraccionesViewModel.class);
        atraccionViewModel.getAtracciones().observe(this, atracciones -> {
            // Actualiza los datos del adaptador cuando cambia la lista de consejos en el ViewModel
            e2pbCargando.setVisibility(View.INVISIBLE);
            atraccionesAdapter.setAtracciones(atracciones);
        });

        atraccionesAdapter.setClickListener(new AtraccionesAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, Atracciones unaAtracciones) {
                Intent i = new Intent(MainAtracciones.this, AtraccionDetalles.class);//no se si esto funciona la verdad eh esta apañado por los pelos y sin sentido
                i.putExtra(MainAtracciones.INFO_ATRACCIONES, unaAtracciones);

                startActivity(i);
            }
        });
    }
}