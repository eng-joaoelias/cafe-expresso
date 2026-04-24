package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ItemPedidoTest {

    private Produto produtoPadrao;

    @BeforeEach
    void setUp() {
        // Preparação: Cria um produto pra uso nos testes do Item
        produtoPadrao = new Produto("Teclado Mecânico", 250.00);
    }

    @Test
    @DisplayName("Deve criar um item de pedido com produto e quantidade válidos")
    void deveCriarItemPedidoComSucesso() {
        ItemPedido item = new ItemPedido(produtoPadrao, 3);
        
        assertAll("Verificação de atributos do item",
            () -> assertEquals(produtoPadrao, item.getProduto(), "O produto deve ser o mesmo que foi passado"),
            () -> assertEquals(3, item.getQuantidade(), "A quantidade deve ser 3"),
            () -> assertEquals("Teclado Mecânico", item.getProduto().getNome(), "O nome do produto dentro do item deve estar correto")
        );
    }

    @Test
    @DisplayName("Deve permitir alterar o produto e a quantidade via setters")
    void deveAlterarAtributosComSetters() {
        ItemPedido item = new ItemPedido(produtoPadrao, 1);
        Produto novoProduto = new Produto("Mouse Gamer", 150.00);
        
        item.setProduto(novoProduto);
        item.setQuantidade(5);
        
        assertEquals(novoProduto, item.getProduto());
        assertEquals(5, item.getQuantidade());
    }
}
