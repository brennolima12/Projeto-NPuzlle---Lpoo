package tabuleiro;

import java.io.Serializable;

import exception.CelulaException;
import exception.NumeroException;

public abstract class Tabuleiro implements TabuleiroInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int[][] celulas;
	protected int numero;
	protected int quantidadeCelulas;
	protected int i;
	protected int j;
	protected boolean ganhou;
	protected boolean maluco;
	protected int maluquice;

	public Tabuleiro() {
		this.ganhou = false;

	}

	public Tabuleiro(boolean maluco, int maluquice) {
		this.maluco = maluco;
		this.maluquice = maluquice;
	}

	public int[][] getCelula() {
		return this.celulas;
	}

	public void setCelula(int[][] celula) throws CelulaException {
		if (celula != null) {
			this.celulas = celula;
		} else {
			throw new CelulaException();
		}

	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) throws NumeroException {
		if (numero > this.getQuantidadeCelulas()) {
			throw new NumeroException(this.getQuantidadeCelulas());
		} else {
			for (int linha = 0; linha < this.getCelula().length; linha++) {
				for (int coluna = 0; coluna < this.getCelula()[linha].length; coluna++) {
					if (this.getCelula()[linha][coluna] == 0) {
						this.getPosicaoNum(numero);
						this.getCelula()[linha][coluna] = numero;
						this.getCelula()[this.i][this.j] = 0;
						return;
					}
				}
			}
		}
	}

	public void getPosicaoNum(int numero) {
		for (int linha = 0; linha < this.getCelula().length; linha++) {
			for (int coluna = 0; coluna < this.getCelula()[linha].length; coluna++) {
				if (this.getCelula()[linha][coluna] == numero) {
					this.i = linha;
					this.j = coluna;
				}
			}
		}
	}

	public abstract void getVerificarNum();

	public int getQuantidadeCelulas() {
		return this.quantidadeCelulas;
	}

	public boolean getGanhou() {
		return this.ganhou;
	}
}
