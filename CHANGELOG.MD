# Changelog

O formato baseado em [Keep a Changelog](https://keepachangelog.com/pt-BR/1.0.0/)

## [1.0.0] - 2025-09-29
### Adicionado
- Nova funcionalidade de notificação quando um pedido é realizado

### Corrigido
- Sem correções

### Modificado
- Sem modificações

## [1.1.0] - 2025-10-03

### Adicionado
- Implementação dos padrões de projeto **Template Method**, **Strategy** e **Observer** para organizar e flexibilizar o fluxo de pedidos e envio de notificações:
  - **Template Method** (`PedidoTemplate`) define o algoritmo de processamento de pedidos, permitindo que subclasses escolham quais notificações enviar.
  - **Strategy** (`PushStrategy`, `EmailStrategy`, `SmsStrategy`) define os diferentes canais de notificação como estratégias independentes, facilitando a adição de novos canais sem alterar código existente.
  - **Observer** (`Usuario` implementando `IObserver`) permite que cada usuário seja notificado de forma personalizada, respeitando seus canais inscritos.
- Criação de subclasses concretas de template:
  - `AdicionarItemPedido` → envia apenas notificação push.
  - `FinalizarPedido` → envia push, email e SMS.
- Estrutura de pacotes reorganizada:
  - `model/` → classes de domínio (`Pedido`, `Usuario`)
  - `observer/` → interface `IObserver`
  - `strategy/` → interface `IStrategy` e implementações de canais
  - `template/` → `PedidoTemplate` e subclasses concretas

### Corrigido
- Ajustes nos serviços de notificação (antes `EmailService`, `SmsService`, `PushService`) para funcionarem com o novo modelo `Pedido` que utiliza `valor` e `Usuario` em vez de `descricao` e `cliente` simples.
- Eliminado acoplamento direto entre `Pedido` e serviços de notificação, evitando chamadas diretas e respeitando o padrão Observer.

### Modificado
- Alteração do ambiente do **Codespaces** para utilizar **Java 17** (anteriormente Java 11).
- Renomeação dos arquivos de serviços de notificação para **Strategy**, refletindo a implementação de padrões de projeto.
- Motivação da mudança de design:
  - Redução de acoplamento entre classes.
  - Maior flexibilidade para adicionar novos tipos de notificações e fluxos de pedidos.
  - Código mais organizado, legível e fácil de manter.

## [1.1.1] - 2025-10-06
### Adicionado
- Sem adições

### Corrigido
- Sem correções

### Modificado
- Textos com maior facilidade de compreensão.