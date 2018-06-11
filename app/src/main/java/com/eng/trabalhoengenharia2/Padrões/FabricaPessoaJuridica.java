package com.eng.trabalhoengenharia2.Padrões;

import com.eng.trabalhoengenharia2.Entidades.PessoaJuridica;

public class FabricaPessoaJuridica implements FabricaTitularAbstrata {

    @Override
    public void criarTitular() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
    }
}
