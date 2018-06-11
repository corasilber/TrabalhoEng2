package com.eng.trabalhoengenharia2.Entidades;

public class Titular {

    private String nome;
    private String CPF;
    private String CNPJ;

    public Titular() {
    }


    public Titular(String numero){
        if(numero.length() > 11){
            setCPF(numero);
        } else {
            setCNPJ(numero);
        }
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
