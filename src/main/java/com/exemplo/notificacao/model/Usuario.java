package com.exemplo.notificacao.model;

import com.exemplo.notificacao.observer.IObserver;
import com.exemplo.notificacao.strategy.IStrategy;

import java.util.HashSet;
import java.util.Set;

public class Usuario implements IObserver {
    private final String nome;
    private final Set<Class<? extends IStrategy>> canaisInscritos = new HashSet<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void inscrever(Class<? extends IStrategy> canal) {
        canaisInscritos.add(canal);
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public void notificar(Pedido pedido, String acao, IStrategy... estrategias) {
        System.out.println("\nRegistrando notificações para " + nome + ":\n" + acao +
                           ". Valor do cupom: R$" + pedido.getValor());

        for (IStrategy e : estrategias) {
            if (canaisInscritos.contains(e.getClass())) {
                e.enviar(pedido, this);
            } else {
                System.out.println("Usuário " + nome + " não ativou " + e.getClass().getSimpleName()
                        + "\nSem notificações enviadas!");
            }
        }
    }
}
