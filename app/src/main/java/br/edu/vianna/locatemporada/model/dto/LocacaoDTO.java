package br.edu.vianna.locatemporada.model.dto;

public class LocacaoDTO {

    private int codigo;

    private String token;

    private String data_inicio;

    private String data_fim;

    private double valor_total;

    private String numeroCartao;

    public LocacaoDTO() {
    }

    public LocacaoDTO(int codigo, String token, String data_inicio, String data_fim, double valor_total, String numeroCartao) {
        this.codigo = codigo;
        this.token = token;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.valor_total = valor_total;
        this.numeroCartao = numeroCartao;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
