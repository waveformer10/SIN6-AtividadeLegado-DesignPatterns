package com.exemplo.notificacao.template;

import com.exemplo.notificacao.strategy.*;

public class FinalizarPedido extends PedidoTemplate {
    @Override
    protected IStrategy[] definirEstrategias() {
        return new IStrategy[]{
            new PushStrategy(),
            new EmailStrategy(),
            new SmsStrategy()
        };
    }

    @Override
    protected String definirAcao() {
        return "Pedido finalizado";
    }
}
