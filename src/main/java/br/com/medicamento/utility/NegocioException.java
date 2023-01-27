package br.com.medicamento.utility;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		// chama o construtor da classe pai, a Exception
		super(message);
	}

}
