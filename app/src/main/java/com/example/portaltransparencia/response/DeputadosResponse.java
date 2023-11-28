package com.example.portaltransparencia.response;

import com.example.portaltransparencia.dto.DeputadoDTO;

import java.util.List;

public class DeputadosResponse {
    private List<DeputadoDTO> dados;

    public List<DeputadoDTO> getDados() {
        return dados;
    }

    public void setDados(List<DeputadoDTO> dados) {
        this.dados = dados;
    }
}
