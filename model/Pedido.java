package model;

import java.util.ArrayList;

public class Pedido {
	private ArrayList <ItemPedido> itens;
	private StatusPedido status;
	
	public Pedido() {
		itens = new ArrayList <ItemPedido>();
	}
	
	public boolean adicionarItem(Produto produto, int quantidade) {
		ItemPedido itemAdd = new ItemPedido(produto, quantidade);
		itens.add(itemAdd);
		if (!itens.contains(itemAdd)) {
			return false;
		}
		return true;
	}
	
	
	public ArrayList<ItemPedido> getItens() {
		return itens;
	}

	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
}
