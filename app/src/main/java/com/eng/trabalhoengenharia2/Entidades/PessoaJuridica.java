package com.eng.trabalhoengenharia2.Entidades;

public class PessoaJuridica extends Titular{

    private String CNPJ;

    @Override
    public String getCNPJ() {
        return CNPJ;
    }

    @Override
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
