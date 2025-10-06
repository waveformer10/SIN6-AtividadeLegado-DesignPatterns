package com.exemplo.notificacao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exemplo.notificacao.model.Pedido;
import com.exemplo.notificacao.model.Usuario;
import com.exemplo.notificacao.template.AdicionarItemPedido;
import com.exemplo.notificacao.template.FinalizarPedido;
import com.exemplo.notificacao.template.PedidoTemplate;
import com.exemplo.notificacao.strategy.EmailStrategy;
import com.exemplo.notificacao.strategy.PushStrategy;
import com.exemplo.notificacao.strategy.SmsStrategy;

@SpringBootApplication
public class NotificacaoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NotificacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Sistema de Notificação de Pedidos ===");

        // Criando usuários
        Usuario usuario1 = new Usuario("Eric");
        Usuario usuario2 = new Usuario("Marcelo");

        usuario1.inscrever(PushStrategy.class);
        usuario1.inscrever(EmailStrategy.class);
        usuario1.inscrever(SmsStrategy.class);

        usuario2.inscrever(SmsStrategy.class);

        // Criando pedidos
        Pedido pedido1 = new Pedido(usuario1, 150.0);
        Pedido pedido2 = new Pedido(usuario2, 200.0);

        // Criando templates
        PedidoTemplate adicionar = new AdicionarItemPedido();
        PedidoTemplate finalizar = new FinalizarPedido();

        System.out.println("\n=== Adicionar item ===");
        adicionar.processarPedido(pedido1);

        System.out.println("\n---\n");

        System.out.println("=== Finalizar pedido ===");
        finalizar.processarPedido(pedido1);
        finalizar.processarPedido(pedido2);

        System.out.println("\n=== Fim da execução ===");
    }
}
