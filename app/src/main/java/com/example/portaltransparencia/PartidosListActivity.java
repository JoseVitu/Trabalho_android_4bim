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

import com.example.portaltransparencia.adapter.PartidoAdapter;
import com.example.portaltransparencia.service.PartidosService;
import com.example.portaltransparencia.dto.PartidoDTO;
import com.example.portaltransparencia.response.PartidoResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PartidosListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PartidoAdapter partidoAdapter;
    private List<PartidoDTO> partidoDTOList;
    private Button btnListarPartidos;
    private EditText etPesquisarPartidos;
    private List<PartidoDTO> partidoDTOListOriginal = new ArrayList<>(); // Corrigir o nome da variável

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos_list);

        recyclerView = findViewById(R.id.recyclerViewPartidos);
        btnListarPartidos = findViewById(R.id.btnListarPartidos);
        etPesquisarPartidos = findViewById(R.id.etPesquisarPartidos);

        // Configuração inicial do RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        partidoDTOList = new ArrayList<>();
        partidoAdapter = new PartidoAdapter(partidoDTOList);
        recyclerView.setAdapter(partidoAdapter);

        // Configuração do botão "Listar Partidos"
        btnListarPartidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarPartidos();
            }
        });


        etPesquisarPartidos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrarPartidos(s.toString());
            }
        });
    }

    private void carregarPartidos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dadosabertos.camara.leg.br/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PartidosService partidosService = retrofit.create(PartidosService.class);

        partidosService.listarPartidos(1, 50).enqueue(new Callback<PartidoResponse>() {
            @Override
            public void onResponse(Call<PartidoResponse> call, Response<PartidoResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("API Success", "Dados recebidos: " + response.body().getDados().toString());
                    partidoDTOList.clear();
                    partidoDTOList.addAll(response.body().getDados());
                    partidoDTOListOriginal.clear();
                    partidoDTOListOriginal.addAll(response.body().getDados());
                    partidoAdapter.notifyDataSetChanged();
                } else {
                    Log.e("API Error", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<PartidoResponse> call, Throwable t) {
                Log.e("API Error", "Failure Message: " + t.getMessage());
            }
        });
    }

    private void filtrarPartidos(String texto) {
        List<PartidoDTO> filteredList = new ArrayList<>();

        for (PartidoDTO partidoDTO : partidoDTOListOriginal) {
            if (partidoDTO.getNome().toLowerCase().contains(texto.toLowerCase()) ||
                    partidoDTO.getSigla().toLowerCase().contains(texto.toLowerCase())) {
                filteredList.add(partidoDTO);
            }
        }

        partidoDTOList.clear(); // Limpe a lista atual antes de adicionar os filtrados
        partidoDTOList.addAll(filteredList);
        partidoAdapter.notifyDataSetChanged();
    }

    }