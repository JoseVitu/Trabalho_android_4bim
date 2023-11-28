package com.example.portaltransparencia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portaltransparencia.R;
import com.example.portaltransparencia.dto.PartidoDTO;

import java.util.List;

public class PartidoAdapter extends RecyclerView.Adapter<PartidoAdapter.PartidoViewHolder> {

    private List<PartidoDTO> partidoDTOS;

    public PartidoAdapter(List<PartidoDTO> partidoDTOS){
        this.partidoDTOS = partidoDTOS;
    }

    @NonNull
    @Override
    public PartidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_partido, parent, false);
        return new PartidoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidoViewHolder holder, int position) {
        PartidoDTO partidoDTO = partidoDTOS.get(position);
        holder.bind(partidoDTO);
    }

    @Override
    public int getItemCount(){
        return partidoDTOS.size();
    }

    public void setPartidos(List<PartidoDTO> partidoDTOS){
        this.partidoDTOS = partidoDTOS;
        notifyDataSetChanged();
    }

    class PartidoViewHolder extends RecyclerView.ViewHolder {

        private TextView nomePartido;
        private TextView siglaPartido;

        PartidoViewHolder(View itemView){
            super(itemView);
            nomePartido = itemView.findViewById(R.id.textViewNomePartido);
            siglaPartido = itemView.findViewById(R.id.textViewSiglaPartido);
        }

        void bind(PartidoDTO partidoDTO){
            nomePartido.setText(partidoDTO.getNome());
            siglaPartido.setText(partidoDTO.getSigla());
        }
    }

}
