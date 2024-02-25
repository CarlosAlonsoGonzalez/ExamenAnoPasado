package com.example.examenanopasado.Examen1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Pelicula>> peliculas;

    public LiveData<ArrayList<Pelicula>> getPeliculas() {
        if (peliculas == null) {
            peliculas = new MutableLiveData<ArrayList<Pelicula>>();
            generarPeliculas();
        }
        return peliculas;
    }

    public void generarPeliculas() {
        new Thread(() -> {

            ServicioApiPeliculas ser = ServicioApiPeliculas.getInstancia();
            Call<List<Pelicula>> llamada = ser.getRepo().getPeliculas();
            llamada.enqueue(new Callback<List<Pelicula>>() {
                @Override
                public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Pelicula> listaPeliculas = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        ArrayList<Pelicula> peliculasProcesadas = Pelicula.generador(listaPeliculas);
                        peliculas.postValue(peliculasProcesadas);
                    }
                }

                @Override
                public void onFailure(Call<List<Pelicula>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }
}
