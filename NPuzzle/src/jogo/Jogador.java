package jogo;

import java.io.Serializable;

public class Jogador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private boolean ganhador;
	private float tempo;
	
	public Jogador(String nome, float tempo) {
		this.nome = nome;
		this.ganhador = false;
		this.tempo = tempo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void ganhar() {
		this.ganhador = true;
	}

	public void perder() {
		this.ganhador = false;
	}
	
	public float getTempo() {
		return this.tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

}
