package repositorio;

import tabuleiro.Tabuleiro;

import java.io.IOException;

import arquivos.Arquivos;

public class RepositorioTabuleiro extends Arquivos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RepositorioTabuleiro() {
		this.setBanco("Save\\");
		this.setArquivo("Tabuleiro");
		criarDiretorio();
	}

	public Tabuleiro salvarJogo(long idTabuleiro, Tabuleiro tabuleiro) throws IOException {		
		tabuleiro = (Tabuleiro)armazenaDados(tabuleiro, idTabuleiro);
		return tabuleiro;
	}
	
}
