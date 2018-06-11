package com.eng.trabalhoengenharia2.Entidades;

public class Relatorio {

    private double consumo;
    private double faturamento;

    public Relatorio() {
    }

    public Relatorio(double consumo, double faturamento) {
        this.consumo = consumo;
        this.faturamento = faturamento;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }
}
