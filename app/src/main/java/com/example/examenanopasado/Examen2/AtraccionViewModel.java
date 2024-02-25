package com.example.examenanopasado.Examen2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtraccionViewModel extends ViewModel {
    private MutableLiveData<Atraccion> atraccion;
    public int idAtraccion;

    public LiveData<Atraccion> getAtraccion(int id) {
        idAtraccion = id;
        if (atraccion == null) {
            atraccion = new MutableLiveData<Atraccion>();
            generarAtraccion(idAtraccion);
        }
        return atraccion;
    }

    public void generarAtraccion(int id) {
        new Thread(() -> {

            ServicioApiAtraccion ser = ServicioApiAtraccion.getInstancia();
            Call<Atraccion> llamada = ser.getRepo().getAtraccion(id);
            llamada.enqueue(new Callback<Atraccion>() {
                @Override
                public void onResponse(Call<Atraccion> call, Response<Atraccion> response) {
                    if (response.isSuccessful()) {
                        Atraccion a = response.body();

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        atraccion.postValue(a);
                    }
                }

                @Override
                public void onFailure(Call<Atraccion> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }
}