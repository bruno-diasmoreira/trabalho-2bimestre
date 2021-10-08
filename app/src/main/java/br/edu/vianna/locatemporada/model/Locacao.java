package br.edu.vianna.locatemporada.model;

import java.io.Serializable;

public class Locacao implements Serializable {

    private int id;
    private int idSituacaoLocacao;

    private String dataInicio;
    private String dataFim;

    private Imovel imovel;

    private Pagamento pagamento;

    public Locacao() {
    }

    public Locacao(int id, int idSituacaoLocacao, String dataInicio, String dataFim, Imovel imovel, Pagamento pagamento) {
        this.id = id;
        this.idSituacaoLocacao = idSituacaoLocacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.imovel = imovel;
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSituacaoLocacao() {
        return idSituacaoLocacao;
    }

    public void setIdSituacaoLocacao(int idSituacaoLocacao) {
        this.idSituacaoLocacao = idSituacaoLocacao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
