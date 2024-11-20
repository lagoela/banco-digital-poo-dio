package com.lagoela.banco_digital;

import com.lagoela.banco_digital.exceptions.ValorInvalidoException;

public interface IConta {
    
    double sacar(double valor) throws ValorInvalidoException;

    double depositar(double valor) throws ValorInvalidoException;

    void imprimirExtrato();
    
    void transferir(double valor, Conta contaDestino) throws ValorInvalidoException;
}
