package model;

import java.util.ArrayList;

public class Pedido {
	private ArrayList <ItemPedido> itens;
	private StatusPedido status;
	
	public Pedido() {
		itens = new ArrayList <ItemPedido>();
		this.status = StatusPedido.EM_PREPARO;
	}
	
	public boolean adicionarItem(Produto produto, int quantidade) {
        if (this.status == StatusPedido.FINALIZADO || this.status == StatusPedido.PAGO) {
            return false;
        }

        for (ItemPedido item : itens) {
            if (item.getProduto().getNome().equals(produto.getNome())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return true;
            }
        }

        return itens.add(new ItemPedido(produto, quantidade));
    }
	
	public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
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
