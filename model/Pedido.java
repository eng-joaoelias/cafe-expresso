package model;

import java.util.ArrayList;

public class Pedido {
	private ArrayList <ItemPedido> itens;
	private StatusPedido status;
	
	
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
