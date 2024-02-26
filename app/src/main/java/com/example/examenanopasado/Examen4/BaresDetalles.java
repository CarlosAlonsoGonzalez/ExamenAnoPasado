package com.example.examenanopasado.Examen4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.examenanopasado.Examen4.Bares;
import com.example.examenanopasado.Examen4.MainBares;
import com.example.examenanopasado.R;

public class BaresDetalles extends AppCompatActivity {
    TextView tvNombre, tvDescripcion, tvEstrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bares_detalles);

        tvNombre = findViewById(R.id.e4tvNombreDetalles);
        tvDescripcion = findViewById(R.id.e4tvDescripcionDetalles);
        tvEstrellas = findViewById(R.id.e4tvEstrellasDetalles);

        Bundle bares = getIntent().getExtras();
        Bares bar = (Bares) bares.getSerializable(MainBares.INFO_BARES);
        tvNombre.setText(bar.getNombre());
        tvDescripcion.setText(bar.getDescripcion());
        tvEstrellas.setText(String.valueOf(bar.getEstrellas()));
    }
}