package com.example.examenanopasado.Examen3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenanopasado.Examen3.TPelicula;
import com.example.examenanopasado.Examen3.TServicioApiPeliculas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TPeliculaViewModel extends ViewModel {
    private MutableLiveData<ArrayList<TPelicula>> peliculas;
    public int numEstrellas;

    public LiveData<ArrayList<TPelicula>> getPeliculas(int estrellas) {
        numEstrellas = estrellas;
        if (peliculas == null) {
            peliculas = new MutableLiveData<ArrayList<TPelicula>>();
            generarPeliculas(numEstrellas);
        }
        return peliculas;
    }

    public void generarPeliculas(int estrellas) {
        new Thread(() -> {

            TServicioApiPeliculas ser = TServicioApiPeliculas.getInstancia();
            Call<List<TPelicula>> llamada = ser.getRepo().getPeliculas(estrellas);
            llamada.enqueue(new Callback<List<TPelicula>>() {
                @Override
                public void onResponse(Call<List<TPelicula>> call, Response<List<TPelicula>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<TPelicula> listaPeliculas = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        ArrayList<TPelicula> peliculasProcesadas = TPelicula.generador(listaPeliculas);
                        peliculas.postValue(peliculasProcesadas);
                    }
                }

                @Override
                public void onFailure(Call<List<TPelicula>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }
}
