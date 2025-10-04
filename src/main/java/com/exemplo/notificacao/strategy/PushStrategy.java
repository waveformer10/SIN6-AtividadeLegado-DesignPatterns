package com.exemplo.notificacao.strategy;

import com.exemplo.notificacao.model.Pedido;
import com.exemplo.notificacao.model.Usuario;

public class PushStrategy implements IStrategy {
    public void enviar(Pedido pedido, Usuario usuario) {
        System.out.println("Notificação push enviado para " + usuario.getNome() +
                           " sobre o pedido no valor de: R$ " + pedido.getValor());
    }
}
