package com.example.examenanopasado.Examen2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.examenanopasado.R;

import java.util.ArrayList;

public class AtraccionDetalles extends AppCompatActivity {
    public static final String INFO_ATRACCIONES = "info de una atraccion";
    RecyclerView rvComentarios;
    ProgressBar e2pbCargando;
    ComentariosAdapter comentariosAdapter;
    private AtraccionViewModel atraccionViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atraccion_detalles);

        rvComentarios = findViewById(R.id.rvComentarios);
        e2pbCargando = findViewById(R.id.e2pbCargando2);
        e2pbCargando.setVisibility(View.VISIBLE);

        rvComentarios.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        comentariosAdapter = new ComentariosAdapter(new ArrayList<>());

        rvComentarios.setAdapter(comentariosAdapter);
        Bundle atraccions = getIntent().getExtras();
        Atracciones atracciones = (Atracciones) atraccions.getSerializable(MainAtracciones.INFO_ATRACCIONES);
        String url = atracciones.getUrl();
        String[]partes = url.split("/");
        int id = Integer.parseInt(partes[5]);


        // Inicializa y observa los cambios en el ViewModel
        atraccionViewModel = new ViewModelProvider(this).get(AtraccionViewModel.class);
        atraccionViewModel.getAtraccion(id).observe(this, atraccion -> {
            // Actualiza los datos del adaptador cuando cambia la lista de consejos en el ViewModel
            Comentario[]comentarios = atraccion.getComentarios();
            e2pbCargando.setVisibility(View.INVISIBLE);
            comentariosAdapter.setComentarios(comentarios);
        });

    }
}