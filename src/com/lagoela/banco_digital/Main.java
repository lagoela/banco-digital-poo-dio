package com.lagoela.banco_digital;

import com.lagoela.banco_digital.exceptions.ValorInvalidoException;

public class Main {
    public static void main(String[] args) {
        Cliente enzo = new Cliente();
        enzo.setNome("Enzo");

        Conta cc = new ContaCorrente(enzo);
        Conta cp = new ContaPoupanca(enzo);

        try {
            cc.depositar(100);
            cc.transferir(100, cp);
        } catch (ValorInvalidoException e) {
            e.printStackTrace();
        }

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        Cliente brunaCliente = new Cliente();
        brunaCliente.setNome("Bruna");

        Conta ccBruConta = new ContaCorrente(brunaCliente);

        try {
            cp.transferir(35, ccBruConta);   
        } catch (Exception e) {
            e.printStackTrace();
        }

        cp.imprimirExtrato();
        ccBruConta.imprimirExtrato();

    }
}
