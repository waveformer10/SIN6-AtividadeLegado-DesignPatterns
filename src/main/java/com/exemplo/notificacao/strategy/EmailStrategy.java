package com.exemplo.notificacao.strategy;

import com.exemplo.notificacao.model.Pedido;
import com.exemplo.notificacao.model.Usuario;

public class EmailStrategy implements IStrategy {
    public void enviar(Pedido pedido, Usuario usuario) {
        System.out.println("Email enviado para " + usuario.getNome() +
                           " sobre o pedido com cupom no valor: R$ " + pedido.getValor());
    }
}
