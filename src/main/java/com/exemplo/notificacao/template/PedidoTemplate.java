package com.exemplo.notificacao.template;

import com.exemplo.notificacao.model.Pedido;
import com.exemplo.notificacao.strategy.IStrategy;

public abstract class PedidoTemplate {

    // Template Method
    public final void processarPedido(Pedido pedido) {
        IStrategy[] estrategias = definirEstrategias();
        String acao = definirAcao();
        pedido.getCliente().notificar(pedido, acao, estrategias);
    }

    protected abstract IStrategy[] definirEstrategias();
    protected abstract String definirAcao();
}
