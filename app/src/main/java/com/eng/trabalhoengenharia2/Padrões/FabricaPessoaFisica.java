package com.eng.trabalhoengenharia2.Padrões;

import com.eng.trabalhoengenharia2.Entidades.PessoaFisica;

public class FabricaPessoaFisica implements FabricaTitularAbstrata {

    @Override
    public void criarTitular() {
        PessoaFisica pessoaFisica = new PessoaFisica();

    }
}
