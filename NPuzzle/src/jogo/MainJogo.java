package jogo;

import java.io.IOException;

import exception.CelulaException;
import exception.NumeroException;


public class MainJogo {

	public static void main(String[] args) throws NumeroException, CelulaException, IOException {
		Inicio i = new Inicio();
		i.Npuzzle();
	}
}
