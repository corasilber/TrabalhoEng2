package com.eng.trabalhoengenharia2;

public class ListaDeConta {




    public void buscaPorMes(int mes){
        //recebe o mes e retorna uma lista de contas com o mes desejado (busca pelo banco de dados)
    }

    public void buscaPorMesAno(int mes, int ano){
        // busca no banco as contas com o mes e o ano especificado, retorna lista
    }

    public void buscaPorTitular(String nome){
        //busca no banco as contas com o titular = nome, retorna lista
    }

    public void geraRelatorio(TipoConta tipoConta, int ano){

        //pegar do banco as contas por mes e somar o consumo total e faturamento mensal total de um ano

        if(tipoConta == TipoConta.AGUA){
            //pega de agua
        } else if(tipoConta == TipoConta.ENERGIA){
            //busca as contas de energia
        }
    }

    public void calcularVariacao(int mes, int ano){
        //a partir de um mes e ano, calcula a variação e percentual desse mes com o
    }
}
