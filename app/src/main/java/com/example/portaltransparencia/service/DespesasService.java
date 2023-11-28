package com.example.portaltransparencia.service;

import com.example.portaltransparencia.response.DespesasResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DespesasService {
    @GET("deputados/{id}/despesas")
    Call<DespesasResponse> listarDespesas(@Path("id") int idDeputado);
}