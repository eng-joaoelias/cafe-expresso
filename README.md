# ☕ Café Expresso - Sistema de Gestão de Pedidos

![Java Unit Test CI](https://github.com/eng-joaoelias/cafe-expresso/actions/workflows/ci_cd_github.yaml/badge.svg?branch=main)
![Java Version](https://img.shields.io/badge/Java-17%20%2F%2021-orange)
![Build](https://img.shields.io/badge/Build-Maven-blue)

Este é um projeto acadêmico e de pesquisa desenvolvido para gerenciar o fluxo de pedidos de uma cafeteria. O sistema foca em lógica de negócio robusta, encapsulamento e integridade de estados, garantindo que o ciclo de vida de um pedido seja respeitado desde a criação até o pagamento.

## 🚀 Funcionalidades Principais

*   **Gestão de Itens:** Adição inteligente de produtos. Se um produto repetido é adicionado, o sistema agrupa as quantidades automaticamente.
*   **Cálculo Automático:** Cada item calcula seu subtotal, e o pedido centraliza o valor total dinamicamente.
*   **Máquina de Estados:** Controle rigoroso de status do pedido:
    *   `PENDENTE` ➡️ `EM_PREPARO` ➡️ `FINALIZADO` ➡️ `PAGO`
*   **Validações:** Impede a finalização de pedidos vazios ou a adição de novos itens em pedidos já encerrados.

## 🛠️ Tecnologias Utilizadas

*   **Java 17/21:** Linguagem base utilizando Programação Orientada a Objetos (POO).
*   **Maven:** Gerenciamento de dependências e automação de build.
*   **JUnit 5:** Framework para testes unitários automatizados.
*   **GitHub Actions:** Pipeline de CI (Integração Contínua) configurado para rodar testes em cada push/pull request.

## 📂 Estrutura do Projeto

O projeto segue o padrão de pastas do Maven:

```text
├── src/
│   ├── main/java/model/      # Classes de negócio (Pedido, Produto, ItemPedido)
│   └── test/java/model/      # Testes unitários (PedidoTest, ItemPedidoTest, etc)
├── .github/workflows/        # Configuração da automação (GitHub Actions)
└── pom.xml                   # Configuração do Maven e dependências
```

## 🧪 Como Executar os Testes

Para garantir que a lógica do sistema está correta, utilizamos testes unitários. Você pode executá-los localmente se tiver o Maven instalado:

```bash
mvn test
```

Os testes cobrem:
1.  Agrupamento de itens duplicados.
2.  Cálculo de subtotal e total geral.
3.  Bloqueio de mudança de status inválida.
4.  Validação de preços e quantidades negativas.

## ⚙️ Automação (CI/CD)

Este repositório está configurado com **GitHub Actions**. Toda alteração no código dispara um workflow que:
1.  Valida a compilação em múltiplas versões do Java (17 e 21).
2.  Executa todos os testes automatizados.
3.  Gera relatórios de execução (Artifacts).

---
Desenvolvido como parte de estudos em do curso Tecologia em Análise e Desenvolvimento de Sistemas da Universidade Estadual do Sudoeste da Bahia.