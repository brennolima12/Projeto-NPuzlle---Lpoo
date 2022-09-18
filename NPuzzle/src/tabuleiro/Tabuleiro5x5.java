package tabuleiro;

import java.util.Random;

public class Tabuleiro5x5 extends Tabuleiro {

	public Tabuleiro5x5() {
		super();
		this.celulas = new int[5][5];
		this.quantidadeCelulas = (25) - 1;
	}
	public Tabuleiro5x5(boolean maluco, int maluquice) {
		super(maluco, maluquice);
		this.celulas = new int[5][5];
		this.quantidadeCelulas = (25) - 1;
	}
		
	public void getVerificarNum() {
		if (this.maluco) {
			Random r = new Random();
			int num = r.nextInt(100);
			if (num <= this.maluquice) {
				int a = r.nextInt(23) + 1;
				int b = r.nextInt(23) + 1;
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
				if (this.getCelula()[0][3] == 4) {
					System.out.println("A posição 4 está correta");
				}
				if (this.getCelula()[0][4] == 5) {
					System.out.println("A posição 5 está correta");
				}
				if (this.getCelula()[1][0] == 6) {
					System.out.println("A posição 6 está correta");
				}
				if (this.getCelula()[1][1] == 7) {
					System.out.println("A posição 7 está correta");
				}
				if (this.getCelula()[1][2] == 8) {
					System.out.println("A posição 8 está correta");
				}
				if (this.getCelula()[1][3] == 9) {
					System.out.println("A posição 9 está correta");
				}
				if (this.getCelula()[1][4] == 10) {
					System.out.println("A posição 10 está correta");
				}
				if (this.getCelula()[2][0] == 11) {
					System.out.println("A posição 11 está correta");
				}
				if (this.getCelula()[2][1] == 12) {
					System.out.println("A posição 12 está correta");
				}
				if (this.getCelula()[2][2] == 13) {
					System.out.println("A posição 13 está correta");
				}
				if (this.getCelula()[2][3] == 14) {
					System.out.println("A posição 14 está correta");
				}
				if (this.getCelula()[2][4] == 15) {
					System.out.println("A posição 15 está correta");
				}
				if (this.getCelula()[3][0] == 16) {
					System.out.println("A posição 16 está correta");
				}
				if (this.getCelula()[3][1] == 17) {
					System.out.println("A posição 17 está correta");
				}
				if (this.getCelula()[3][2] == 18) {
					System.out.println("A posição 18 está correta");
				}
				if (this.getCelula()[3][3] == 19) {
					System.out.println("A posição 19 está correta");
				}
				if (this.getCelula()[3][4] == 20) {
					System.out.println("A posição 20 está correta");
				}
				if (this.getCelula()[4][0] == 21) {
					System.out.println("A posição 21 está correta");
				}
				if (this.getCelula()[4][1] == 22) {
					System.out.println("A posição 22 está correta");
				}
				if (this.getCelula()[4][2] == 23) {
					System.out.println("A posição 23 está correta");
				}
				if (this.getCelula()[4][3] == 24) {
					System.out.println("A posição 24 está correta");
				}
				if (this.getCelula()[4][4] == 0) {
					System.out.println("A posição 25 está correta");
				}
				if (this.getCelula()[0][0] == 1 && this.getCelula()[0][1] == 2 && this.getCelula()[0][2] == 3
						&& this.getCelula()[0][3] == 4 && this.getCelula()[0][4] == 5 && this.getCelula()[1][0] == 6
						&& this.getCelula()[1][1] == 7 && this.getCelula()[1][2] == 8 && this.getCelula()[1][3] == 9
						&& this.getCelula()[1][4] == 10 && this.getCelula()[2][0] == 11 && this.getCelula()[2][1] == 12
						&& this.getCelula()[2][2] == 13 && this.getCelula()[2][3] == 14 && this.getCelula()[2][4] == 15
						&& this.getCelula()[3][0] == 16 && this.getCelula()[3][1] == 17 && this.getCelula()[3][2] == 18
						&& this.getCelula()[3][3] == 19 && this.getCelula()[3][4] == 20 && this.getCelula()[4][0] == 21
						&& this.getCelula()[4][1] == 22 && this.getCelula()[4][2] == 23 && this.getCelula()[4][3] == 24
						&& this.getCelula()[4][4] == 0) {
					System.out.println("Parabéns, você ganhou!");
					this.ganhou = true;
				}
				return;
			}
		}
	}
}
