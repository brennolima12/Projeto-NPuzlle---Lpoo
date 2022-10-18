package jogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import exception.CelulaException;
import exception.NumeroException;
import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro3x3;
import tabuleiro.Tabuleiro4x4;
import tabuleiro.Tabuleiro5x5;
import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro3x3;

import java.io.IOException;
import java.util.Random;

import exception.CelulaException;
import repositorio.RepositorioJogador;
import repositorio.RepositorioTabuleiro;

public class Inicio {

	public void Npuzzle() throws NumeroException, CelulaException, IOException {
		System.out.println("Digite seu nome");
		Scanner string = new Scanner(System.in);
		String nome = string.next();
		
		Scanner s = new Scanner(System.in);
		Comunicacao c1 = new Comunicacao();
		c1.printDificuldade();
		int dificuldade = s.nextInt();

		while (dificuldade < 1 || dificuldade > 3 ) { //escolher dificuldade
			System.out.println("Escolha uma dificuldade 1, 2 ou 3");
			dificuldade = s.nextInt();
		}

		System.out.println("Dificuldade escolhida foi: " + dificuldade);

		System.out.println("Digite 0 para ser maluco, ou qualquer outro número para ser normal.");

		int isMaluco = s.nextInt(); //ser maluco
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

		// salvar jogo
		// RepositorioTabuleiro r = new RepositorioTabuleiro();
		// r.salvarJogo(1, tabuleiro);

		// dar load jogo
		// RepositorioTabuleiro r = new RepositorioTabuleiro();
		// Tabuleiro jogoSalvo = (Tabuleiro) r.buscarArquivoPorId(1);
		// tabuleiro.setCelula(jogoSalvo.getCelula());
		long tempoInicial = System.currentTimeMillis();
		do {
			print(tabuleiro.getCelula());
			System.out.println("Escolha o numero para ir para a celula vazia ");
			int ajuda = s.nextInt();
			System.out.println(c1.help(ajuda));
			if (ajuda != 80 && ajuda != 81 && ajuda != 91 && ajuda != 92 && ajuda != 93) { //ajuda
				tabuleiro.setNumero(ajuda);
				tabuleiro.getVerificarNum();
			}else if (ajuda == 80) { //salvar jogo
				RepositorioTabuleiro r = new RepositorioTabuleiro();
				
				r.salvarJogo(1, tabuleiro);
				System.out.println("Seu jogo foi salvo.");	
			}
			else if(ajuda == 81) { //carregar jogo
				 RepositorioTabuleiro r = new RepositorioTabuleiro();
				 Tabuleiro jogoSalvo = (Tabuleiro) r.buscarArquivoPorId(1);
				 tabuleiro.setCelula(jogoSalvo.getCelula());
			}
		} while (!tabuleiro.getGanhou());  
		
		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		
		//Salvar jogador e sua pontuacao
		RepositorioJogador repoJogador = new RepositorioJogador();
		Jogador j = new Jogador(nome, tempoFinal);
		long id = repoJogador.tamanhoBanco();
		repoJogador.salvarPontuacao(id, j);
		ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
		
		//Listar todos os jogadores
		for (int i = 0; i < repoJogador.tamanhoBanco(); i++) {
			Jogador listaJogador = (Jogador) repoJogador.buscarArquivoPorId(i);
			float tempo = (float) (listaJogador.getTempo()/1000);
			//System.out.println("------------------------------------------------------------");
			//System.out.println( "Tempo: " + tempo + "s");
			
			
			listaJogadores.add(listaJogador);
			//System.out.println(listaJogador.getNome());
		
		
		}
		
		List<Jogador> jogadoresMenorTempo = listaJogadores.stream()
			    .sorted(Comparator.comparing(Jogador::getTempo))
			    .collect(Collectors.toList());
		
		for (int i = 0; i < jogadoresMenorTempo.size(); i++) {
			float tempo = (float) (((Jogador) jogadoresMenorTempo.get(i)).getTempo()/1000);
			String n = (((Jogador) jogadoresMenorTempo.get(i)).getNome());
			System.out.println("------------------------------------------------------------");
			System.out.println("Tempo: " + tempo +  "s");
			System.out.println("Nome: " + n);
		}
		
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
