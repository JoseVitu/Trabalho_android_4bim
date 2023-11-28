package com.example.portaltransparencia.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portaltransparencia.DespesasActivity;
import com.example.portaltransparencia.R;
import com.example.portaltransparencia.dto.DeputadoDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DeputadoAdapter extends RecyclerView.Adapter<DeputadoAdapter.DeputadoViewHolder> {

    private List<DeputadoDTO> deputadoDTOS;

    // Construtor
    public DeputadoAdapter(List<DeputadoDTO> deputadoDTOS) {
        this.deputadoDTOS = deputadoDTOS;
    }

    @NonNull
    @Override
    public DeputadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deputado, parent, false);
        return new DeputadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeputadoViewHolder holder, int position) {
        DeputadoDTO deputadoDTO = deputadoDTOS.get(position);
        holder.bind(deputadoDTO);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DespesasActivity.class);
                intent.putExtra("ID_DEPUTADO", deputadoDTO.getId()); // Supondo que DeputadoDTO tem um método getId()
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return deputadoDTOS.size();
    }

    public void setDeputados(List<DeputadoDTO> deputadoDTOS) {
        this.deputadoDTOS = deputadoDTOS;
    }

    class DeputadoViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeTextView;
        private TextView partidoTextView;
        private ImageView fotoImageView;

        DeputadoViewHolder(View itemView) {
            super(itemView);
            nomeTextView = itemView.findViewById(R.id.textViewNomeDeputado);
            partidoTextView = itemView.findViewById(R.id.textViewPartidoDeputado);
            fotoImageView = itemView.findViewById(R.id.imageViewFotoDeputado);
        }

        void bind(DeputadoDTO deputadoDTO) {
            nomeTextView.setText(deputadoDTO.getNome());
            partidoTextView.setText(deputadoDTO.getSiglaPartido());
            Picasso.get().load(deputadoDTO.getUrlFoto()).into(fotoImageView);

        }
    }
}

