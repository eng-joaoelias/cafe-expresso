import java.util.ArrayList;
import java.util.List;

class Produto {
    public String nome; // Erro: Deveria ser privado (Encapsulamento)
    public double preco;
}

class ItemPedido {
    public Produto produto;
    public int quantidade;
}

public class SistemaCafe {
    public static List<Produto> cardapio = new ArrayList<>();
    public static List<ItemPedido> carrinho = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--- SISTEMA CAFÉ EXPRESSO (MODO GAMBIARRA) ---");

        // RF01 - Cadastro de produtos
        Produto p1 = new Produto();
        p1.nome = "Café Expresso";
        p1.preco = 5.00;
        cardapio.add(p1);

        Produto p2 = new Produto();
        p2.nome = "Pão de Queijo";
        p2.preco = 4.50;
        cardapio.add(p2);
        
        System.out.println("Produtos cadastrados com sucesso!");

        // RF02 - Adicionar itens ao pedido
        adicionarDireto(0, 2); // 2 Cafés
        adicionarDireto(1, 3); // 3 Pães de queijo
        
        System.out.println("Itens no carrinho:");
        for (ItemPedido item : carrinho) {
            System.out.println(item.quantidade + "x " + item.produto.nome);
        }
    }

    //Acessa listas globais e não trata exceções (IndexOutOfBounds)
    public static void adicionarDireto(int index, int qtd) {
        ItemPedido novoItem = new ItemPedido();
        novoItem.produto = cardapio.get(index);
        novoItem.quantidade = qtd;
        carrinho.add(novoItem);
    }
}
