package com.example.portaltransparencia.dto;

public class DespesaDTO {
    private int ano;
    private int mes;

    private String tipoDocumento;
    private long codDocumento;
    private String tipoDespesa;
    private long codTipoDocumento;
    private String dataDocumento;
    private String numDocumento;
    private Double valorDocumento;
    private String urlDocumento;
    private String nomeFornecedor;
    private String cnpjCpfFornecedor;
    private Double valorLiquido;
    private Double valorGlosa;
    private String numRessarcimento;
    private long codLote;
    private long parcela;

    @Override
    public String toString() {
        return "DespesaDTO{" +
                "ano=" + ano +
                ", mes=" + mes +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", codDocumento=" + codDocumento +
                ", tipoDespesa='" + tipoDespesa + '\'' +
                ", codTipoDocumento=" + codTipoDocumento +
                ", dataDocumento='" + dataDocumento + '\'' +
                ", numDocumento='" + numDocumento + '\'' +
                ", valorDocumento=" + valorDocumento +
                ", urlDocumento='" + urlDocumento + '\'' +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                ", cnpjCpfFornecedor='" + cnpjCpfFornecedor + '\'' +
                ", valorLiquido=" + valorLiquido +
                ", valorGlosa=" + valorGlosa +
                ", numRessarcimento='" + numRessarcimento + '\'' +
                ", codLote=" + codLote +
                ", parcela=" + parcela +
                '}';
    }

    public DespesaDTO() {
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(long codDocumento) {
        this.codDocumento = codDocumento;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public long getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(long codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpjCpfFornecedor() {
        return cnpjCpfFornecedor;
    }

    public void setCnpjCpfFornecedor(String cnpjCpfFornecedor) {
        this.cnpjCpfFornecedor = cnpjCpfFornecedor;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Double getValorGlosa() {
        return valorGlosa;
    }

    public void setValorGlosa(Double valorGlosa) {
        this.valorGlosa = valorGlosa;
    }

    public String getNumRessarcimento() {
        return numRessarcimento;
    }

    public void setNumRessarcimento(String numRessarcimento) {
        this.numRessarcimento = numRessarcimento;
    }

    public long getCodLote() {
        return codLote;
    }

    public void setCodLote(long codLote) {
        this.codLote = codLote;
    }

    public long getParcela() {
        return parcela;
    }

    public void setParcela(long parcela) {
        this.parcela = parcela;
    }
}