package jogo;

public class Jogador {
	private String nome;
	private int movimentos;
	private boolean ganhador;
	
	public Jogador (String nome) {
		this.nome = nome;
		this.movimentos = 0;
		this.ganhador = false;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMovimentos() {
		return this.movimentos;
	}
	
	public void setMovimentos(int movimentos) {
		this.movimentos = movimentos;
	}
	
	public void ganhar() {
		this.ganhador = true;
	}
	
	public void perder() {
		this.ganhador = false;
	}
	
	
	
	
	
	
	
}
