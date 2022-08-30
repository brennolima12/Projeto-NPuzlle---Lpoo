package jogo;

public class Comunicacao {

	
	public void printDificuldade() {
		System.out.println("Escolha a dificuldade do jogo: 1 - Fácil, 2 - Médio ou 3 - dificíl.");
		System.out.println("Se quiser ajuda após o jogo começar, digite:\n91 para ajuda no fácil.\n92 no médio.\n93 no díficil.");
	}
	
	
	
	
	
	
	
	
	
	public void help(int num) {
		if(num == 91) {
			System.out.println("Para ganhar na dificuldade fácil deve fazer essa sequência: -1- -2- -3- Na primeira linha. -4- -5- -6- Na segunda linha. -7- -8- -0- Na terceira linha.");
		}																				
		else if(num == 92) {
			System.out.println("Para ganhar na dificuldade média deve fazer essa sequência: -1- -2- -3- -4- Na primeira linha. -5- -6- -7- -8- Na segunda linha. -9- -10- -11- -12- Na terceira linha. -13- -14- -15- -0- Na quarta linha.");
		}
		else if(num == 93) {
			System.out.println("Para ganhar na dificuldade dificíl deve fazer essa sequência: -1- -2- -3- -4- -5- Na primeira linha. -6- -7- -8- -9- -10- Na segunda linha. -11- -12- -13- -14- -15- Na terceira linha. -16- -17- -18- -19- -20- Na quarta linha. -21- -22- -23- -24- -0- Na quinta linha.");
		}
	}
	

}
