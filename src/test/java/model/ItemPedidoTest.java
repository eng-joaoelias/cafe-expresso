package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
class ItemPedidoTest {

	private Produto cafe;

    @BeforeEach
    void setUp() {
        cafe = new Produto("Café Expresso", 5.00);
    }

    @Test
    @DisplayName("Deve criar um item de pedido com produto e quantidade válidos")
    void deveCriarItemPedidoComSucesso() {
        ItemPedido item = new ItemPedido(cafe, 3);
        
        assertAll("Verificação de atributos do item",
            () -> assertEquals(cafe, item.getProduto()),
            () -> assertEquals(3, item.getQuantidade()),
            () -> assertEquals(15.00, item.getSubtotal(), 0.001, "O subtotal deve ser 3 * 5.00")
        );
    }

    @Test
    @DisplayName("Deve calcular o subtotal corretamente após alteração de quantidade")
    void deveRecalcularSubtotalAoAlterarQuantidade() {
        ItemPedido item = new ItemPedido(cafe, 2);
        item.setQuantidade(4);
        
        assertEquals(20.00, item.getSubtotal(), 0.001);
    }
    
    @Test
    @DisplayName("Deve permitir alterar o produto e refletir no subtotal")
    void deveAlterarProdutoERefletirNoSubtotal() {
        ItemPedido item = new ItemPedido(cafe, 2);
        Produto pãoDeQueijo = new Produto("Pão de Queijo", 4.50);
        
        item.setProduto(pãoDeQueijo);
        
        assertEquals(9.00, item.getSubtotal(), 0.001, "O subtotal deve atualizar com o preço do novo produto");
    }
    
}
