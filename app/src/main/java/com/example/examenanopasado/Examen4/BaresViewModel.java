package com.example.examenanopasado.Examen4;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenanopasado.Examen4.Bares;
import com.example.examenanopasado.Examen4.ServicioApiBares;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaresViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Bares>> bares;
    public int numEstrellas;

    public LiveData<ArrayList<Bares>> getBares(int estrellas) {
        numEstrellas = estrellas;
        if (bares == null) {
            bares = new MutableLiveData<ArrayList<Bares>>();
            if(estrellas == 0){
                generarTodosLosBares();
            }else{
                generarBares(numEstrellas);
            }


        }
        return bares;
    }

    public void generarBares(int estrellas) {
        new Thread(() -> {

            ServicioApiBares ser = ServicioApiBares.getInstancia();
            Call<List<Bares>> llamada = ser.getRepo().getBaresPorEstrella(estrellas);
            llamada.enqueue(new Callback<List<Bares>>() {
                @Override
                public void onResponse(Call<List<Bares>> call, Response<List<Bares>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Bares> listaBares = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        ArrayList<Bares> baresProcesados = Bares.generador(listaBares);
                        bares.postValue(baresProcesados);
                    }
                }

                @Override
                public void onFailure(Call<List<Bares>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }

    public void generarTodosLosBares() {
        new Thread(() -> {

            ServicioApiBares ser = ServicioApiBares.getInstancia();
            Call<List<Bares>> llamada = ser.getRepo().getBares();
            llamada.enqueue(new Callback<List<Bares>>() {
                @Override
                public void onResponse(Call<List<Bares>> call, Response<List<Bares>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Bares> listaBares = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        ArrayList<Bares> baresProcesados = Bares.generador(listaBares);
                        bares.postValue(baresProcesados);
                    }
                }

                @Override
                public void onFailure(Call<List<Bares>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }
}
