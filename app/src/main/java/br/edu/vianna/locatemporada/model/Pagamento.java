package br.edu.vianna.locatemporada.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pagamento implements Serializable {

    @SerializedName("valor_pago")
    private double valorPago;

    private String idTransacaoPagamento;

    public Pagamento() {
    }

    public Pagamento(double valorPago, String idTransacaoPagamento) {
        this.valorPago = valorPago;
        this.idTransacaoPagamento = idTransacaoPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getIdTransacaoPagamento() {
        return idTransacaoPagamento;
    }

    public void setIdTransacaoPagamento(String idTransacaoPagamento) {
        this.idTransacaoPagamento = idTransacaoPagamento;
    }
}
