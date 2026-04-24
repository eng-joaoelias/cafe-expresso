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
	    if (this.status == StatusPedido.EM_PREPARO && !itens.isEmpty()) {
	        this.status = StatusPedido.FINALIZADO;
	    }
	}
	
	public void pagar() {
		this.setStatus(StatusPedido.PAGO);
	}
	
	public void enviarParaCozinha() {
	    this.setStatus(StatusPedido.EM_PREPARO);
	}
	
	public ArrayList<ItemPedido> getItens() {
		return itens;
	}

	public StatusPedido getStatus() {
		return status;
	}
	private void setStatus(StatusPedido status) {
		this.status = status;
	}
	
}
