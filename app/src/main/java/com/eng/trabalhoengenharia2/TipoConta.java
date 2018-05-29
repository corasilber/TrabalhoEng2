package com.eng.trabalhoengenharia2;

public enum TipoConta {

    ENERGIA("Energia"),
    AGUA("Água");

    private String descricao;

    TipoConta(String tipo){
        this.descricao = tipo;
    }
    TipoConta(){}

    public String getTipo(){
        return descricao;
    }

}
