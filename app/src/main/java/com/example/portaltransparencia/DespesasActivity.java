package com.example.portaltransparencia;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portaltransparencia.service.DespesasService;
import com.example.portaltransparencia.adapter.DespesaAdapter;
import com.example.portaltransparencia.dto.DespesaDTO;
import com.example.portaltransparencia.response.DespesasResponse;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DespesasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DespesaAdapter adapter;
    private List<DespesaDTO> listaDespesas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas_list);

        recyclerView = findViewById(R.id.recycler_view_despesas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listaDespesas = new ArrayList<>();
        adapter = new DespesaAdapter(listaDespesas);
        recyclerView.setAdapter(adapter);

        int idDeputado = getIntent().getIntExtra("ID_DEPUTADO", -1);
        if (idDeputado != -1) {
            carregarDespesas(idDeputado);
        }
    }

    private void carregarDespesas(int idDeputado) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dadosabertos.camara.leg.br/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DespesasService service = retrofit.create(DespesasService.class);
        Call<DespesasResponse> call = service.listarDespesas(idDeputado);

        call.enqueue(new Callback<DespesasResponse>() {
            @Override
            public void onResponse(Call<DespesasResponse> call, Response<DespesasResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listaDespesas.clear();
                    listaDespesas.addAll(response.body().getDados());
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("API Error", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<DespesasResponse> call, Throwable t) {
                Log.e("API Error", "Network Error: " + t.getMessage());
            }
        });
    }
}
