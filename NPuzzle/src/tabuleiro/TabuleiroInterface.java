package tabuleiro;

import exception.CelulaException;
import exception.NumeroException;

public interface TabuleiroInterface {

	public int[][] getCelula();

	public void setCelula(int[][] celula) throws CelulaException;

	public int getNumero();

	public void setNumero(int numero) throws NumeroException;

	public void getPosicaoNum(int numero);

	public void getVerificarNum();

	public int getQuantidadeCelulas();

	public boolean getGanhou();
}
