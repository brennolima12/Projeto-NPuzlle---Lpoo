package tabuleiro;

import java.util.Random;

public class Tabuleiro4x4 extends Tabuleiro {

	public Tabuleiro4x4() {
		super();
		this.celulas = new int[4][4];
		this.quantidadeCelulas = (16) - 1;
	}

	public Tabuleiro4x4(boolean maluco, int maluquice) {
		super(maluco, maluquice);
		this.celulas = new int[4][4];
		this.quantidadeCelulas = (16) - 1;
	}

	public void getVerificarNum() {
		if (this.maluco) {
			Random r = new Random();
			int num = r.nextInt(100);
			if (num <= this.maluquice) {
				int a = r.nextInt(14) + 1;
				int b = r.nextInt(14) + 1;
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
				if (this.getCelula()[1][0] == 5) {
					System.out.println("A posição 5 está correta");
				}
				if (this.getCelula()[1][1] == 6) {
					System.out.println("A posição 6 está correta");
				}
				if (this.getCelula()[1][2] == 7) {
					System.out.println("A posição 7 está correta");
				}
				if (this.getCelula()[1][3] == 8) {
					System.out.println("A posição 8 está correta");
				}
				if (this.getCelula()[2][0] == 9) {
					System.out.println("A posição 9 está correta");
				}
				if (this.getCelula()[2][1] == 10) {
					System.out.println("A posição 10 está correta");
				}
				if (this.getCelula()[2][2] == 11) {
					System.out.println("A posição 11 está correta");
				}
				if (this.getCelula()[2][3] == 12) {
					System.out.println("A posição 12 está correta");
				}
				if (this.getCelula()[3][0] == 13) {
					System.out.println("A posição 13 está correta");
				}
				if (this.getCelula()[3][1] == 14) {
					System.out.println("A posição 14 está correta");
				}
				if (this.getCelula()[3][2] == 15) {
					System.out.println("A posição 15 está correta");
				}
				if (this.getCelula()[3][3] == 0) {
					System.out.println("A posição 16 está correta");
					if (this.getCelula()[0][0] == 1 && this.getCelula()[0][1] == 2 && this.getCelula()[0][2] == 3
							&& this.getCelula()[0][3] == 4 && this.getCelula()[1][0] == 5 && this.getCelula()[1][1] == 6
							&& this.getCelula()[1][2] == 7 && this.getCelula()[1][3] == 8 && this.getCelula()[2][0] == 9
							&& this.getCelula()[2][1] == 10 && this.getCelula()[2][2] == 11
							&& this.getCelula()[2][3] == 12 && this.getCelula()[3][0] == 13
							&& this.getCelula()[3][1] == 14 && this.getCelula()[3][2] == 15
							&& this.getCelula()[3][3] == 0) {
						System.out.println("Parabéns, você ganhou!");
						this.ganhou = true;
					}

				}
				return;
			}

		}
	}
}
