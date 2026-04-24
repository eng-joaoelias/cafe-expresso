package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ProdutoTest {

    @Test
    @DisplayName("Deve criar um produto corretamente com construtor")
    void deveCriarProdutoComConstrutor() {
        Produto produto = new Produto("Notebook", 3500.00);
        
        assertEquals("Notebook", produto.getNome());
        assertEquals(3500.00, produto.getPrecounitario());
    }

    @Test
    @DisplayName("Deve alterar os valores usando setters")
    void deveAlterarValoresComSetters() {
        Produto produto = new Produto("Mouse", 50.00);
        
        produto.setNome("Teclado");
        produto.setPrecounitario(150.00);
        
        assertEquals("Teclado", produto.getNome());
        assertEquals(150.00, produto.getPrecounitario());
    }
}
