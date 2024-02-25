package com.example.examenanopasado.Examen1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActoresViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Actor>> actores;

    public LiveData<ArrayList<Actor>> getActores() {
        if (actores == null) {
            actores = new MutableLiveData<ArrayList<Actor>>();
            generarActores();
        }
        return actores;
    }

    public void generarActores() {
        new Thread(() -> {

            ServicioApiPeliculas ser = ServicioApiPeliculas.getInstancia();
            Call<List<Pelicula>> llamada = ser.getRepo().getPeliculas();
            llamada.enqueue(new Callback<List<Pelicula>>() {
                @Override
                public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Actor> listaActores = new ArrayList<>();

                        // Iterar sobre cada película para obtener sus actores
                        for (Pelicula pelicula : response.body()) {
                            for (Actor actor : pelicula.getActores()) {
                                listaActores.add(actor);
                            }
                        }

                        // Utiliza el método generador() de Actor para procesar los actores
                        ArrayList<Actor> actoresProcesados = Actor.generador(listaActores);
                        actores.postValue(actoresProcesados);
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
