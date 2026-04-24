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

	@Test
    @DisplayName("Deve calcular o valor total corretamente para múltiplos itens")
    void deveCalcularTotalCorretamente() {
        // 2 Cafés (2 * 5.00 = 10.00)
        pedido.adicionarItem(cafe, 2);
        // 3 Pães de Queijo (3 * 4.50 = 13.50)
        pedido.adicionarItem(paoDeQueijo, 3);

        double totalEsperado = 23.50;
        double totalObtido = pedido.calcularTotal();

        assertEquals(totalEsperado, totalObtido, 0.001, "O cálculo do total deve ser a soma dos subprodutos"); //O terceiro valor é para garantir que minimas desigualdades decorrentes do compilador nao interfiram
    }

	@Test
    @DisplayName("O valor total de um pedido vazio deve ser zero")
    void deveRetornarZeroParaPedidoVazio() {
        assertEquals(0.0, pedido.calcularTotal(), "Um pedido sem itens deve ter valor total igual a 0");
    }

	@Test
    @DisplayName("Deve alterar e recuperar o status do pedido")
    void deveGerenciarStatusDoPedido() {
        // Supondo que StatusPedido seja um Enum com o valor NOVO ou PENDENTE
        pedido.setStatus(StatusPedido.NOVO); 
        assertEquals(StatusPedido.NOVO, pedido.getStatus());
    }

	@Test
    @DisplayName("Deve alterar o status para FINALIZADO ao finalizar o pedido")
    void deveAlterarStatusParaFinalizado() {
        // Ação
        pedido.finalizarPedido();

        // Verificação
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus(), 
            "O status do pedido deve ser FINALIZADO após chamar finalizarPedido()");
    }
}
