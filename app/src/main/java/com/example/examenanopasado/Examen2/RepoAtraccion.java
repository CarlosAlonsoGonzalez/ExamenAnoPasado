package com.example.examenanopasado.Examen2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoAtraccion {
    @GET("/api/atracciones/{id}")
    Call<Atraccion> getAtraccion(@Path("id") int id);
}
