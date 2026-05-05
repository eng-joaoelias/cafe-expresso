package model;

public class Produto {
	private String nome;
	private double precounitario;
	
	public Produto(String nome, double precounitario) {
        this.nome = nome;
        setPrecounitario(precounitario); // Usa o setter para validar no construtor
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
        if (precounitario < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.precounitario = precounitario;
    }
	
	
}
