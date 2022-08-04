package jogo;

public class Tabuleiro {
	
	private int[][] celulas;
	private int numero;
	private int quantidadeCelulas;
	
	
	public Tabuleiro (int dimensaoJogo) {
		this.celulas = new int[dimensaoJogo][dimensaoJogo];
		this.quantidadeCelulas = (dimensaoJogo * dimensaoJogo) - 1;
	
	}
	
	public int[][] getCelula(){
		return this.celulas;
	}
	
	public void setCelula (int[][] celula) {
		this.celulas = celula;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero, int i, int j) {
		for(int linha = 0; linha < this.getCelula().length; linha++) {
			for(int coluna = 0; coluna < this.getCelula().length; coluna++) {
				if(this.getCelula()[linha][coluna] == numero) {
					this.celulas[linha][coluna] = 0;
		if (numero <= this.quantidadeCelulas && numero > 0) {
			if (this.getCelula()[i][j] == 0) {
				this.celulas[i][j] = numero;
				
						}
					}
				}
				
			}
		}
	}
	
	public int getQuantidadeCelulas(){
		return this.quantidadeCelulas;
	}
	
	public void setQuantidadeCelulas (int quantidadeCelulas) {
		this.quantidadeCelulas = quantidadeCelulas;
	}
}
