package com.eng.trabalhoengenharia2;

public enum TipoConta {

    ENERGIA("ENERGIA"),
    AGUA("AGUA");

    private String descricao;

    TipoConta(String tipo){
        this.descricao = tipo;
    }
    TipoConta(){}

    public String getTipo(){
        return descricao;
    }

}
