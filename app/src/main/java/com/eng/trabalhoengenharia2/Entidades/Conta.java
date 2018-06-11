package com.eng.trabalhoengenharia2.Entidades;

public class Conta {

    private String titular;
    private TipoConta tipoConta;
    private int mes;
    private int ano;
    private double leituraAnterior;
    private double leituraAtual;
    private double valorConta;
    private double leituraMes;
    private Conta contaAnoAnterior;
    private boolean pessoaFisica;

    public Conta(){}

    public Conta(Titular titular, TipoConta tipoConta, int mes, int ano, double leituraAnterior, double leituraAtual, boolean pessoa) {
        if(pessoa) this.titular = titular.getCPF();
        if(!pessoa) this.titular = titular.getCNPJ();
        this.tipoConta = tipoConta;
        this.mes = mes;
        this.ano = ano;
        this.leituraAnterior = leituraAnterior;
        this.leituraAtual = leituraAtual;
        this.leituraMes = leituraMes;
        this.contaAnoAnterior = null;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
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

    public boolean isPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(boolean pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public double getLeituraAtual() {
        return leituraAtual;
    }

    public void setLeituraAtual(double leituraAtual) {
        this.leituraAtual = leituraAtual;
    }

    public double getLeituraMes() {
        return leituraMes;
    }

    public void setLeituraMes(double leituraMes) {
        this.leituraMes = leituraMes;
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }

    public Conta getContaAnoAnterior() {
        return contaAnoAnterior;
    }

    public void setContaAnoAnterior(Conta contaAnoAnterior) {
        this.contaAnoAnterior = contaAnoAnterior;
    }
}
