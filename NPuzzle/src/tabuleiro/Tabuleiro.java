package tabuleiro;


public class Tabuleiro {

	protected int[][] celulas;
	protected int numero;
	protected int quantidadeCelulas;
	protected int i;
	protected int j;
	protected boolean ganhou;

	public Tabuleiro() {
		this.ganhou = false;

	}

	public int[][] getCelula() {
		return this.celulas;
	}

	public void setCelula(int[][] celula) {
		this.celulas = celula;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if (numero > this.getQuantidadeCelulas()) {
			System.out.println("Escolha um numero até " + this.getQuantidadeCelulas());
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
	
	public void getVerificarNum() {
		for (int linha = 0; linha < this.getCelula().length; linha++) {
			for (int coluna = 0; coluna < this.getCelula()[linha].length; coluna++) {
				if (this.getCelula()[0][0] == 1) {
					System.out.println("lala");
					return;
				}
			}
		}
	}
	
	public int getQuantidadeCelulas() {
		return this.quantidadeCelulas;
	}

	public void setQuantidadeCelulas(int quantidadeCelulas) {
		this.quantidadeCelulas = quantidadeCelulas;
	}
	
	public boolean getGanhou() {
		return this.ganhou;
	}
}
