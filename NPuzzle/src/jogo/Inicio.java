package jogo;

import java.util.Random;
import java.util.Scanner;

import exception.CelulaException;
import exception.NumeroException;
import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro3x3;
import tabuleiro.Tabuleiro4x4;
import tabuleiro.Tabuleiro5x5;

public class Inicio {

	public void Npuzzle() throws NumeroException, CelulaException {
		Scanner s = new Scanner(System.in);
		Comunicacao c1 = new Comunicacao();
		c1.printDificuldade();
		int dificuldade = s.nextInt();

		while (dificuldade < 1 || dificuldade > 3) {
			System.out.println("Escolha uma dificuldade 1, 2 ou 3");
			dificuldade = s.nextInt();
		}

		System.out.println("Dificuldade escolhida foi: " + dificuldade);

		System.out.println("Digite 0 para ser maluco, ou qualquer outro número para ser normal.");

		int isMaluco = s.nextInt();
		int maluquice = 0;
		if (isMaluco == 0) {
			System.out.println("Agora Escolha seu nível de maluquice de 0 a 100");
			maluquice = s.nextInt();
		}

		Tabuleiro tabuleiro = null;

		int[][] Matriz = null;

		if (dificuldade == 1) {
			if (isMaluco == 0) {
				tabuleiro = new Tabuleiro3x3(true, maluquice);
			} else {
				tabuleiro = new Tabuleiro3x3();
			}
			Matriz = new int[3][3];
		} else if (dificuldade == 2) {
			if (isMaluco == 0) {
				tabuleiro = new Tabuleiro4x4(true, maluquice);
			} else {
				tabuleiro = new Tabuleiro4x4();
			}
			Matriz = new int[4][4];
		} else if (dificuldade == 3) {
			if (isMaluco == 0) {
				tabuleiro = new Tabuleiro5x5(true, maluquice);
			} else {
				tabuleiro = new Tabuleiro5x5();
			}
			Matriz = new int[5][5];
		}

		int contador = 0;
		for (int linha = 0; linha < Matriz.length; linha++) {
			for (int coluna = 0; coluna < Matriz[0].length; coluna++) {
				Matriz[linha][coluna] = contador;
				contador++;
			}
		}

		shuffle(Matriz);
		tabuleiro.setCelula(Matriz);
		do {
			print(tabuleiro.getCelula());
			System.out.println("Escolha o numero para ir para a celula vazia ");
			int ajuda = s.nextInt();
			c1.help(ajuda);
			if (ajuda != 91 && ajuda != 92 && ajuda != 93) {
				tabuleiro.setNumero(ajuda);
				tabuleiro.getVerificarNum();
			}
		} while (!tabuleiro.getGanhou());

	}

	public static void print(int[][] Matriz2) {
		for (int linha = 0; linha < Matriz2.length; linha++) {
			for (int coluna = 0; coluna < Matriz2[linha].length; coluna++) {
				System.out.print("-" + Matriz2[linha][coluna] + "-" + "  ");
			}
			System.out.println();
		}

	}

	public static void shuffle(int[][] a) {
		Random random = new Random();

		for (int i = a.length - 1; i > 0; i--) {
			for (int j = a[i].length - 1; j > 0; j--) {
				int m = random.nextInt(i + 1);
				int n = random.nextInt(j + 1);

				int temp = a[i][j];
				a[i][j] = a[m][n];
				a[m][n] = temp;
			}
		}
	}

}
