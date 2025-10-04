package com.exemplo.notificacao.observer;

import com.exemplo.notificacao.model.Pedido;
import com.exemplo.notificacao.strategy.IStrategy;

public interface IObserver {
    void notificar(Pedido pedido, String acao, IStrategy... estrategias);
}
