package com.exemplo.notificacao.model;

import com.exemplo.notificacao.observer.IObserver;

public class Pedido {
    private final IObserver cliente;
    private final double valor;

    public Pedido(IObserver cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;
    }

    public double getValor() { 
        return this.valor; 
    }

    public IObserver getCliente() {
        return this.cliente;
    }
}
