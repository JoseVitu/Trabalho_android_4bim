package com.example.portaltransparencia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.portaltransparencia.R;
import com.example.portaltransparencia.dto.DespesaDTO;

import java.util.List;

import android.widget.TextView;

public class DespesaAdapter extends RecyclerView.Adapter<DespesaAdapter.DespesaViewHolder> {

    private List<DespesaDTO> despesas;

    public DespesaAdapter(List<DespesaDTO> despesas) {
        this.despesas = despesas;
    }

    @Override
    public DespesaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_despesa, parent, false);
        return new DespesaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DespesaViewHolder holder, int position) {
        DespesaDTO despesa = despesas.get(position);
        holder.bind(despesa);
    }

    @Override
    public int getItemCount() {
        return despesas.size();
    }

    class DespesaViewHolder extends RecyclerView.ViewHolder {
        private TextView tipoDespesaTextView;
        private TextView valorDespesaTextView;

        private TextView dataDespesa;

        private TextView fornecedorDespesa;

        DespesaViewHolder(View itemView) {
            super(itemView);
            tipoDespesaTextView = itemView.findViewById(R.id.textViewTipoDespesa);
            valorDespesaTextView = itemView.findViewById(R.id.textViewValorDespesa);
            dataDespesa = itemView.findViewById(R.id.textViewDataDespesa);
            fornecedorDespesa = itemView.findViewById(R.id.textViewNomeFornecedor);
        }

        void bind(DespesaDTO despesa) {
            tipoDespesaTextView.setText("Tipo de Despesa: " + despesa.getTipoDespesa());
            fornecedorDespesa.setText("Nome Fornecedor: " + despesa.getNomeFornecedor());
            valorDespesaTextView.setText("Valor: " + String.format("%.2f", despesa.getValorDocumento()));
            dataDespesa.setText("Data: " + despesa.getDataDocumento());
        }

    }
}

