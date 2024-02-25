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
import java.util.Arrays;

public class ListaActores extends AppCompatActivity {
    public static final String INFO_ACTORES = "info actores";
    RecyclerView rvActores;
    ActoresAdapter actoresAdapter;
    ActoresViewModel actoresViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_actores);

        rvActores = findViewById(R.id.rvActores);

        rvActores.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        Bundle actors = getIntent().getExtras();
        Pelicula pelicula = (Pelicula) actors.getSerializable(MainPeliculas.INFO_PELICULAS);

        actoresAdapter = new ActoresAdapter(new ArrayList<>());

        rvActores.setAdapter(actoresAdapter);
        actoresAdapter.setActores(pelicula.getActores());


       /* // Inicializa y observa los cambios en el ViewModel
        actoresViewModel = new ViewModelProvider(this).get(ActoresViewModel.class);
        actoresViewModel.getActores().observe(this, actores -> {
            // Actualiza los datos del adaptador cuando cambia la lista de consejos en el ViewModel
            actoresAdapter.setActores(actores);
        });
*/
        actoresAdapter.setClickListener(new ActoresAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, Actor unActor) {
                Intent i = new Intent(ListaActores.this, ActoresDetalles.class);//no se si esto funciona la verdad eh esta apañado por los pelos y sin sentido
                i.putExtra(ListaActores.INFO_ACTORES,unActor);

                startActivity(i);
            }
        });
    }
}