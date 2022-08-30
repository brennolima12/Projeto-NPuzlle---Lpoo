package jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro3x3;
import tabuleiro.Tabuleiro4x4;
import tabuleiro.Tabuleiro5x5;

public class Inicio {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Comunicacao c1 = new Comunicacao();
		c1.printDificuldade();
		int n = s.nextInt();
		
		while(n < 1 || n > 3 )  {
			System.out.println("Escolha uma dificuldade 1, 2 ou 3");
			n = s.nextInt();
		}
		
		System.out.println("Dificuldade escolhida foi: " + n);

		Tabuleiro t2 = null;
		
		
		int[][] Matriz = null;

		if (n == 1) {
			t2 = new Tabuleiro3x3();
			Matriz = new int[3][3];
		} else if (n == 2) {
			t2 = new Tabuleiro4x4();
			Matriz = new int[4][4];
		} else if (n == 3) {
			t2 = new Tabuleiro5x5();
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
		t2.setCelula(Matriz);
		do {
			print(t2.getCelula());
			System.out.println("Escolha o numero para ir para a celula vazia ");
			int num = s.nextInt();
			c1.help(num);
			if (num != 91 && num != 92 && num != 93) {
				t2.setNumero(num);
				t2.getVerificarNum();
			}
		} while (!t2.getGanhou());
		
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
