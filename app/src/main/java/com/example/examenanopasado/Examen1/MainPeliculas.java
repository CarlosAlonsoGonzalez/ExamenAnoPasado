package com.example.examenanopasado.Examen1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.examenanopasado.R;

import java.util.ArrayList;

public class MainPeliculas extends AppCompatActivity {
    public static final String INFO_PELICULAS = "info de una pelicula";
    RecyclerView rvPeliculas;
    PeliculasAdapter peliculasAdapter;
    PeliculaViewModel peliculaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_peliculas);

        rvPeliculas = findViewById(R.id.rvPeliculas);
        rvPeliculas.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        peliculasAdapter = new PeliculasAdapter(new ArrayList<>());

        rvPeliculas.setAdapter(peliculasAdapter);

        // Inicializa y observa los cambios en el ViewModel
        peliculaViewModel = new ViewModelProvider(this).get(PeliculaViewModel.class);
        peliculaViewModel.getPeliculas().observe(this, peliculas -> {
            // Actualiza los datos del adaptador cuando cambia la lista de consejos en el ViewModel
            peliculasAdapter.setPeliculas(peliculas);
        });

        peliculasAdapter.setClickListener(new PeliculasAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, Pelicula unaPelicula) {
                Intent i = new Intent(MainPeliculas.this, ListaActores.class);//no se si esto funciona la verdad eh esta apañado por los pelos y sin sentido
                i.putExtra(MainPeliculas.INFO_PELICULAS,unaPelicula);

                startActivity(i);
            }
        });


    }
}