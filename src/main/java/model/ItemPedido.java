package model;

public class ItemPedido {

	private Produto produto;
	private int quantidade;
	
	public ItemPedido(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.quantidade = quantidade;
    }
	
	public double getSubtotal() {
	    return this.produto.getPrecounitario() * this.quantidade;
	}
	
}
