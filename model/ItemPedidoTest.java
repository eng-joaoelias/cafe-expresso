package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ItemPedidoTest {

    private Produto produtoPadrao;

    @BeforeEach
    void setUp() {
        // Preparação: Criamos um produto que será usado nos testes do Item
        produtoPadrao = new Produto("Teclado Mecânico", 250.00);
    }
}
