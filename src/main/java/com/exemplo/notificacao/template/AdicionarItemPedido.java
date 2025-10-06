package com.exemplo.notificacao.template;

import com.exemplo.notificacao.strategy.IStrategy;
import com.exemplo.notificacao.strategy.PushStrategy;

public class AdicionarItemPedido extends PedidoTemplate {
    @Override
    protected IStrategy[] definirEstrategias() {
        return new IStrategy[]{ new PushStrategy() };
    }

    @Override
    protected String definirAcao() {
        return "Item adicionado sem alteração de preço";
    }
}
