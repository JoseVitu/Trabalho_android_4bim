package com.example.portaltransparencia.service;

import com.example.portaltransparencia.response.DeputadosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DeputadosService {
    @GET("deputados")
    Call<DeputadosResponse> listarDeputados(@Query("pagina") int pagina, @Query("itens") int itens);
}

