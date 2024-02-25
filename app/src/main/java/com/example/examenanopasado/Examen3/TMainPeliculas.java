package com.example.examenanopasado.Examen3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.examenanopasado.Examen1.ListaActores;
import com.example.examenanopasado.Examen1.MainPeliculas;
import com.example.examenanopasado.Examen1.Pelicula;
import com.example.examenanopasado.Examen1.PeliculaViewModel;
import com.example.examenanopasado.Examen1.PeliculasAdapter;
import com.example.examenanopasado.R;

import java.util.ArrayList;

public class TMainPeliculas extends AppCompatActivity {

    private static final String INFO_TPELICULAS = "info de peliculas";
    RecyclerView e3rvPeliculas;
    Spinner e3spEstrellas;
    ProgressBar e3pbCargando;
    String [] courses = {"Estrellas", "5", "4", "3", "2", "1"};
    int estrellas;
    TPeliculasAdapter peliculasAdapter;
    TPeliculaViewModel peliculaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmain_peliculas);

        e3rvPeliculas = findViewById(R.id.e3rvTpeliculas);
        e3spEstrellas = findViewById(R.id.e3spEstrellas);
        e3pbCargando = findViewById(R.id.e3pbCargando);
        e3pbCargando.setVisibility(View.INVISIBLE);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e3spEstrellas.setAdapter(ad);
        int position = e3spEstrellas.getSelectedItemPosition();
        e3spEstrellas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Obtiene la posición seleccionada en el Spinner
                e3pbCargando.setVisibility(View.VISIBLE);
                if (i == 0) {
                    return;
                }

                // Obtiene el valor seleccionado del array 'courses' usando la posición
                String seleccion = courses[i];

                // Ahora 'selectedCourse' contiene la opción seleccionada por el usuario
                // Puedes hacer lo que quieras con esta selección, como mostrarla en un TextView
                // o realizar alguna acción basada en la elección.
                switch (i){
                    case 1:
                        estrellas = 5;
                        cogerInfo(estrellas);
                        break;
                    case 2:
                        estrellas = 4;
                        cogerInfo(estrellas);
                        break;
                    case 3:
                        estrellas = 3;
                        cogerInfo(estrellas);
                        break;
                    case 4:
                        estrellas = 2;
                        cogerInfo(estrellas);
                        break;
                    case 5:
                        estrellas = 1;
                        cogerInfo(estrellas);
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                return;
            }
        });

    }

    public void cogerInfo(int numEsrellas){
        e3rvPeliculas.setLayoutManager(new LinearLayoutManager(TMainPeliculas.this.getApplicationContext()));

        peliculasAdapter = new TPeliculasAdapter(new ArrayList<>());

        e3rvPeliculas.setAdapter(peliculasAdapter);

        // Inicializa y observa los cambios en el ViewModel
        peliculaViewModel = new ViewModelProvider(TMainPeliculas.this).get(TPeliculaViewModel.class);
        peliculaViewModel.getPeliculas(estrellas).observe(TMainPeliculas.this, peliculas -> {
            // Actualiza los datos del adaptador cuando cambia la lista de consejos en el ViewModel
            e3pbCargando.setVisibility(View.INVISIBLE);
            peliculasAdapter.setTPeliculas(peliculas);
        });

        peliculasAdapter.setClickListener(new TPeliculasAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, TPelicula unaPelicula) {
                Intent i = new Intent(TMainPeliculas.this, ListaActores.class);//no se si esto funciona la verdad eh esta apañado por los pelos y sin sentido
                i.putExtra(TMainPeliculas.INFO_TPELICULAS,unaPelicula);

                startActivity(i);
            }
        });
    }
}