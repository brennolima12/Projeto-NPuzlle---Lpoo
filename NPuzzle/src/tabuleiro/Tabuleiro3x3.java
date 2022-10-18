package tabuleiro;

import java.io.Serializable;
import java.util.Random;

public class Tabuleiro3x3 extends Tabuleiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Tabuleiro3x3() {
		super();
		this.celulas = new int[3][3];
		this.quantidadeCelulas = (9) - 1;
	}

	public Tabuleiro3x3(boolean maluco, int maluquice) {
		super(maluco, maluquice);
		this.celulas = new int[3][3];
		this.quantidadeCelulas = (9) - 1;
	}

	
	public void getVerificarNum() {
		if (this.maluco) {
			Random r = new Random();
			int num = r.nextInt(100);
			if (num <= this.maluquice) {
				int a = r.nextInt(7) + 1;
				int b = r.nextInt(7) + 1;
				try {
					setNumero(a);
					setNumero(b);
				} catch (Exception Ex) {
					System.out.println(Ex);
				}
			}
		}
		for (int linha = 0; linha < this.getCelula().length; linha++) {
			for (int coluna = 0; coluna < this.getCelula()[linha].length;) {
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

				if (this.getCelula()[0][0] == 1 && this.getCelula()[0][1] == 2 && this.getCelula()[0][2] == 3
						&& this.getCelula()[1][0] == 4 && this.getCelula()[1][1] == 5 && this.getCelula()[1][2] == 6
						&& this.getCelula()[2][0] == 7 && this.getCelula()[2][1] == 8 && this.getCelula()[2][2] == 0) {
					System.out.println("Parabéns, você ganhou!");
					this.ganhou = true;
				}
				return;
			}
		}
	}
}
