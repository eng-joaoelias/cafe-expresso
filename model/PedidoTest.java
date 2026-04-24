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
}
