package com.eng.trabalhoengenharia2;

public class Conta {

    private Titular titular;
    private TipoConta tipoConta;
    private int mes;
    private int ano;
    private double leituraAnterior;
    private double leituraAtual;

    public Conta(){}

    public Conta(Titular titular, TipoConta tipoConta, int mes, int ano, double leituraAnterior, double leituraAtual) {
        this.titular = titular;
        this.tipoConta = tipoConta;
        this.mes = mes;
        this.ano = ano;
        this.leituraAnterior = leituraAnterior;
        this.leituraAtual = leituraAtual;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getLeituraAnterior() {
        return leituraAnterior;
    }

    public void setLeituraAnterior(double leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
    }

    public double getLeituraAtual() {
        return leituraAtual;
    }

    public void setLeituraAtual(double leituraAtual) {
        this.leituraAtual = leituraAtual;
    }
}
