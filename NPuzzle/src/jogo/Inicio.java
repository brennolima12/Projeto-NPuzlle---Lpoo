package jogo;

public class Inicio {
	public static void main(String[]args) {
		Tabuleiro t1 = new Tabuleiro(3);
		int [][]Matriz = new int [3][3];
		
		Matriz [0][0] = 1;
		Matriz [0][1] = 2;
		Matriz [0][2] = 3;
		Matriz [1][0] = 4;
		Matriz [1][1] = 5;
		Matriz [1][2] = 6;
		Matriz [2][0] = 7;
		Matriz [2][2] = 9;
		t1.setCelula(Matriz);
		t1.setNumero(14, 2, 1);
		
		for(int linha = 0; linha < Matriz.length; linha++) {
			for(int coluna = 0; coluna < Matriz[0].length; coluna++) {
				System.out.println(Matriz[linha][coluna]);
			}
		}
		
		
		
		
		
	}

}
