package exception;

public class NumeroException extends Exception {
	
	public NumeroException(int numero) {
		super("Escolha um numero até " + numero);
	}
	


}
