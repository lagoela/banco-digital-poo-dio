package com.lagoela.banco_digital;

import com.lagoela.banco_digital.exceptions.ValorInvalidoException;

public abstract class Conta implements IConta{

    private static int SEQUENCIA_NUMERO_CONTA = 1;
    private static final int AGENCIA_PADRAO = 341;

    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;
    
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIA_NUMERO_CONTA++;
        this.cliente = cliente;
    }

    protected void checarValorInformado(double valor) throws ValorInvalidoException {
        if (valor <= 0) throw new ValorInvalidoException();
    }

    @Override
    public double depositar(double valor) throws ValorInvalidoException {
        checarValorInformado(valor);

        this.saldo += valor;
        return this.saldo;
    }
    
    @Override
    public double sacar(double valor) throws ValorInvalidoException{
        checarValorInformado(valor);

        if (this.saldo < valor) {
            throw new ValorInvalidoException();
        }

        return this.saldo;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        try {
            this.sacar(valor);
            contaDestino.depositar(valor);

        } catch (ValorInvalidoException e) {
            e.printStackTrace();
        }
        
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public void imprimirInfosComum() {
        System.out.println(String.format("Titular %s", this.cliente.getNome()));
        System.out.println(String.format("Agência %d", this.agencia));
        System.out.println(String.format("Conta %d", this.conta));
        System.out.println(String.format("Saldo %.2f", this.saldo));
    }
    
}
