package com.eng.trabalhoengenharia2;

public class Titular {

    private String nome;
    private String CPF;
    private String CNPJ;
    private String CPForCNPj;

    public Titular() {
    }

    public Titular(String numero){
        this.CPForCNPj = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
