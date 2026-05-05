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
        pedido = new Pedido();
        cafe = new Produto("Café Expresso", 5.00);
        paoDeQueijo = new Produto("Pão de Queijo", 4.50);
    }
    
    @Test
    @DisplayName("Deve agrupar quantidades ao adicionar o mesmo produto repetidamente")
    void deveAgruparItensDuplicados() {
        pedido.adicionarItem(cafe, 2);
        pedido.adicionarItem(cafe, 3);

        assertEquals(1, pedido.getItens().size(), "Não deve criar um novo objeto ItemPedido para o mesmo produto");
        assertEquals(5, pedido.getItens().get(0).getQuantidade(), "A quantidade deve ser a soma das adições");
        assertEquals(25.00, pedido.calcularTotal(), 0.001);
    }
    
    @Test
    @DisplayName("Não deve permitir adicionar itens se o pedido estiver FINALIZADO ou PAGO")
    void naoDeveAdicionarItemAposFinalizar() {
        pedido.adicionarItem(paoDeQueijo, 1);
        pedido.enviarParaCozinha();
        pedido.finalizarPedido();

        boolean resultado = pedido.adicionarItem(cafe, 1);

        assertFalse(resultado, "Deveria retornar false ao tentar adicionar item em pedido finalizado");
        assertEquals(1, pedido.getItens().size(), "A lista de itens não deve ter aumentado");
    }
    
    @Test
    @DisplayName("Deve calcular o total corretamente usando os subtotais dos itens")
    void deveCalcularTotalCorretamente() {
        pedido.adicionarItem(cafe, 2);
        pedido.adicionarItem(paoDeQueijo, 2);
        
        assertEquals(19.00, pedido.calcularTotal(), 0.001);
    }
    
    @Test
    @DisplayName("Deve respeitar o fluxo: PENDENTE -> EM_PREPARO -> FINALIZADO")
    void deveSeguirFluxoDeEstados() {
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());// Estado inicial

        pedido.enviarParaCozinha();// Para Cozinha
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());

        pedido.adicionarItem(cafe, 1); // Finalizar (precisa de item)
        pedido.finalizarPedido();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }
    
    @Test
    @DisplayName("Não deve finalizar pedido se ele ainda estiver como PENDENTE")
    void naoDeveFinalizarPedidoDireto() {
        pedido.adicionarItem(cafe, 1);
        // Pula o enviarParaCozinha()
        pedido.finalizarPedido();

        assertNotEquals(StatusPedido.FINALIZADO, pedido.getStatus(), "Pedido não pode ser finalizado sem passar pela cozinha");
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }
    
    @Test
    @DisplayName("Deve permitir o pagamento em qualquer estágio (conforme regra atual)")
    void devePermitirPagar() {
        pedido.pagar();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }
    
    @Test
    @DisplayName("O valor total de um pedido sem itens deve ser zero")
    void deveRetornarZeroParaPedidoVazio() {
        assertEquals(0.0, pedido.calcularTotal());
    }
}
