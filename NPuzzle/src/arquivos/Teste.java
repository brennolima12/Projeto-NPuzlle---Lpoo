package arquivos;

import tabuleiro.Tabuleiro3x3;

import java.io.IOException;
import java.util.Random;

import exception.CelulaException;
import repositorio.RepositorioTabuleiro;

public class Teste {
	public static void main(String[] args) throws IOException, CelulaException {
		Tabuleiro3x3 t = new Tabuleiro3x3();
		RepositorioTabuleiro r = new RepositorioTabuleiro();
		System.out.println((r.salvarJogo(1, t)).toString());
		System.out.println(r.buscarArquivoPorId(1).toString());
		
		int[][] Matriz = null;
		Matriz = new int[3][3];
		
		shuffle(Matriz);
		t.setCelula(Matriz);
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
