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
	
	public double calcularTotal(){
		double vlrASerPago = 0;
		for (ItemPedido itemPedido : itens) {
			vlrASerPago = vlrASerPago + itemPedido.getProduto().getPrecounitario()*itemPedido.getQuantidade();
		}
		return vlrASerPago;
	}

	public void finalizarPedido() {
		this.setStatus(status.FINALIZADO);
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
