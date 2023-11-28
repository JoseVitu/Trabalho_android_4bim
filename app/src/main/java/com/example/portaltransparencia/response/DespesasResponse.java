package com.example.portaltransparencia.response;


import com.example.portaltransparencia.dto.DespesaDTO;

import java.util.List;

public class DespesasResponse {
    private List<DespesaDTO> dados;

    public List<DespesaDTO> getDados() {
        return dados;
    }

    public void setDados(List<DespesaDTO> dados) {
        this.dados = dados;
    }
}
