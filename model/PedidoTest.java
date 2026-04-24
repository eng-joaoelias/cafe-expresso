package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class PedidoTest {
	private Pedido pedido;
    private Produto cafe;
    private Produto paoDeQueijo;

    @BeforeEach
    void setUp() {
        // Inicializa um novo pedido e alguns produtos antes de cada teste
        pedido = new Pedido();
        cafe = new Produto("Café Expresso", 5.00);
        paoDeQueijo = new Produto("Pão de Queijo", 4.50);
    }

	@Test
    @DisplayName("Deve adicionar um item ao pedido com sucesso")
    void deveAdicionarItemComSucesso() {
        boolean resultado = pedido.adicionarItem(cafe, 2);

        assertTrue(resultado, "O método adicionarItem deve retornar true");
        assertEquals(1, pedido.getItens().size(), "A lista de itens deve conter exatamente 1 item");
        assertEquals("Café Expresso", pedido.getItens().get(0).getProduto().getNome());
    }
}
