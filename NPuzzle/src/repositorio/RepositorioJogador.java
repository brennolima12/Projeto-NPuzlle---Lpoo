package repositorio;

import java.io.IOException;

import arquivos.Arquivos;
import jogo.Jogador;
import tabuleiro.Tabuleiro;

public class RepositorioJogador extends Arquivos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RepositorioJogador() {
		this.setBanco("Scores\\");
		this.setArquivo("Jogador");
		criarDiretorio();
	}

	public Jogador salvarPontuacao(long idJogador, Jogador jogador) throws IOException {		
		jogador = (Jogador)armazenaDados(jogador, idJogador);
		return jogador;
	}

}
