package com.example.portaltransparencia;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portaltransparencia.adapter.DeputadoAdapter;
import com.example.portaltransparencia.service.DeputadosService;
import com.example.portaltransparencia.dto.DeputadoDTO;
import com.example.portaltransparencia.response.DeputadosResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeputadosListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DeputadoAdapter adapter;
    private List<DeputadoDTO> deputadoDTOList;
    private Button btnListarDeputados;
    private EditText etPesquisarDeputados;
    private List<DeputadoDTO> deputadoDTOListOriginal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputados_list);

        recyclerView = findViewById(R.id.recyclerViewDeputados);
        btnListarDeputados = findViewById(R.id.btnListarDeputados);
        etPesquisarDeputados = findViewById(R.id.etPesquisarDeputados);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        deputadoDTOList = new ArrayList<>();
        adapter = new DeputadoAdapter(deputadoDTOList);
        recyclerView.setAdapter(adapter);


        btnListarDeputados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarDeputados();
            }
        });


        // Configuração da pesquisa
        etPesquisarDeputados.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrarDeputados(s.toString());
            }
        });
    }

    private void carregarDeputados() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dadosabertos.camara.leg.br/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DeputadosService deputadosService = retrofit.create(DeputadosService.class);

        // Chamar a API de forma assíncrona
        deputadosService.listarDeputados(1, 200).enqueue(new Callback<DeputadosResponse>() {
            @Override
            public void onResponse(Call<DeputadosResponse> call, Response<DeputadosResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("API Success", "Dados recebidos: " + response.body().getDados().toString());
                    deputadoDTOList.clear();
                    deputadoDTOList.addAll(response.body().getDados());
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("API Error", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<DeputadosResponse> call, Throwable t) {
                Log.e("API Error", "Network Error: " + t.getMessage());
            }
        });
    }

    private void filtrarDeputados(String texto) {

        List<DeputadoDTO> filteredList = new ArrayList<>();

        for (DeputadoDTO deputadoDTO : deputadoDTOListOriginal) {
            if (deputadoDTO.getNome().toLowerCase().contains(texto.toLowerCase()) ||
                    deputadoDTO.getSiglaPartido().toLowerCase().contains(texto.toLowerCase())) {
                filteredList.add(deputadoDTO);
            }
        }

        adapter.setDeputados(filteredList);
        adapter.notifyDataSetChanged();
    }


}

