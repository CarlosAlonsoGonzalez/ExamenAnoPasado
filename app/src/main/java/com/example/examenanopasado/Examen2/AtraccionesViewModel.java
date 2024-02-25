package com.example.examenanopasado.Examen2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtraccionesViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Atracciones>> atracciones;

    public LiveData<ArrayList<Atracciones>> getAtracciones() {
        if (atracciones == null) {
            atracciones = new MutableLiveData<ArrayList<Atracciones>>();
            generarAtracciones();
        }
        return atracciones;
    }

    public void generarAtracciones() {
        new Thread(() -> {

            ServicioApiAtracciones ser = ServicioApiAtracciones.getInstancia();
            Call<List<Atracciones>> llamada = ser.getRepo().getAtracciones();
            llamada.enqueue(new Callback<List<Atracciones>>() {
                @Override
                public void onResponse(Call<List<Atracciones>> call, Response<List<Atracciones>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Atracciones> listaAtracciones = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        ArrayList<Atracciones> atraccionesProcesadas = Atracciones.generador(listaAtracciones);
                        atracciones.postValue(atraccionesProcesadas);
                    }
                }

                @Override
                public void onFailure(Call<List<Atracciones>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }
}
