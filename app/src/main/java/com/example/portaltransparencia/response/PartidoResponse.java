package com.example.portaltransparencia.response;

import com.example.portaltransparencia.dto.PartidoDTO;

import java.util.List;

public class PartidoResponse {

        private List<PartidoDTO> dados;

    public List<PartidoDTO> getDados() {
        return dados;
    }

    public void setDados(List<PartidoDTO> dados) {
        this.dados = dados;
    }
}

