package tabuleiro;

public class Tabuleiro3x3 extends Tabuleiro{

	public Tabuleiro3x3() {
		super();
		this.celulas = new int[3][3];
		this.quantidadeCelulas = (9) - 1; 

	}
	int contador = 1;
	public void getVerificarNum() {
		for (int linha = 0; linha < this.getCelula().length; linha++) {
			for (int coluna = 0; coluna < this.getCelula()[linha].length; coluna++) {
				if (this.getCelula()[0][0] == 1) {
					System.out.println("A posição 1 está correta");			
				}
				if (this.getCelula()[0][1] == 2) {
					System.out.println("A posição 2 está correta");
				}
				if (this.getCelula()[0][2] == 3) {
					System.out.println("A posição 3 está correta");
				}
				if (this.getCelula()[1][0] == 4) {
					System.out.println("A posição 4 está correta");
				}
				if (this.getCelula()[1][1] == 5) {
					System.out.println("A posição 5 está correta");
				}
				if (this.getCelula()[1][2] == 6) {
					System.out.println("A posição 6 está correta");
				}
				if (this.getCelula()[2][0] == 7) {
					System.out.println("A posição 7 está correta");
				}
				if (this.getCelula()[2][1] == 8) {
					System.out.println("A posição 8 está correta");
				}
				if (this.getCelula()[2][2] == 0) {
					System.out.println("A posição 9 está correta");
				}
				
				if (this.getCelula()[0][0] == 1 && this.getCelula()[0][1] == 2 && this.getCelula()[0][2] == 3 && this.getCelula()[1][0] == 4 && this.getCelula()[1][1] == 5 
					&& this.getCelula()[1][2] == 6 && this.getCelula()[2][0] == 7 && this.getCelula()[2][1] == 8 && this.getCelula()[2][2] == 0) {
					System.out.println("Parabéns, você ganhou!");
					this.ganhou = true;
				}
				return;
				}
			}
		}
	}
	
	
