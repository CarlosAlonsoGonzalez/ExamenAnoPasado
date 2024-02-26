package com.example.examenanopasado.Examen4;

import com.example.examenanopasado.Examen4.Bares;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoBares {
    @GET("/api/bares/")
    Call<List<Bares>> getBares();

    @GET("/api/bares/")
    Call<List<Bares>> getBaresPorEstrella(@Query("estrellas") int num);
}
