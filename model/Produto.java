package model;

public class Produto {
	private String nome;
	private double precounitario;
	
	public Produto(String nome, double precounitario) {
		super();
		this.nome = nome;
		this.precounitario = precounitario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecounitario() {
		return precounitario;
	}
	public void setPrecounitario(double precounitario) {
		this.precounitario = precounitario;
	}
	
	
}
