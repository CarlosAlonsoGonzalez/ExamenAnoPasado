package com.example.examenanopasado.Examen4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.examenanopasado.Examen1.ListaActores;
import com.example.examenanopasado.Examen3.TMainPeliculas;
import com.example.examenanopasado.Examen3.TPelicula;
import com.example.examenanopasado.Examen3.TPeliculaViewModel;
import com.example.examenanopasado.Examen3.TPeliculasAdapter;
import com.example.examenanopasado.R;

import java.util.ArrayList;

public class MainBares extends AppCompatActivity {


    private static final String INFO_BARES = "info de bares";
    RecyclerView e4rvBares;
    Spinner e4spEstrellas;
    String [] courses = {"Estrellas", "5", "4", "3", "2", "1"};
    int estrellas;
    BaresAdapter baresAdapter;
    BaresViewModel baresViewModel;
    Button btFiltrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_bares);

        e4rvBares = findViewById(R.id.rvBares);
        e4spEstrellas = findViewById(R.id.e4spEstrellas);
        btFiltrar = findViewById(R.id.e4btFiltrar);

        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e4spEstrellas.setAdapter(ad);

        // Configuración inicial del RecyclerView, adaptador y ViewModel
        e4rvBares.setLayoutManager(new LinearLayoutManager(this));
        baresAdapter = new BaresAdapter(new ArrayList<>());
        e4rvBares.setAdapter(baresAdapter);
        baresViewModel = new ViewModelProvider(this).get(BaresViewModel.class);
        estrellas = 0;
        baresViewModel.getBares(estrellas).observe(this, bares -> {
            baresAdapter.setBares(bares);
            baresAdapter.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
        });


        btFiltrar.setOnClickListener((v) -> {
            int position = e4spEstrellas.getSelectedItemPosition();
            switch (position) {
                case 1:
                    estrellas = 5;
                    break;
                case 2:
                    estrellas = 4;
                    break;
                case 3:
                    estrellas = 3;
                    break;
                case 4:
                    estrellas = 2;
                    break;
                case 5:
                    estrellas = 1;

                    break;
                default:
                    estrellas = 0;
                    baresViewModel.generarTodosLosBares();// Manejar el caso predeterminado si es necesario
                    break;
            }
            if(estrellas!=0){
                baresViewModel.generarBares(estrellas);
            }

        });
    }

}