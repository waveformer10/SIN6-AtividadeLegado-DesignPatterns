package com.exemplo.notificacao.strategy;

import com.exemplo.notificacao.model.Pedido;
import com.exemplo.notificacao.model.Usuario;

public interface IStrategy {
    void enviar(Pedido pedido, Usuario usuario);
}
