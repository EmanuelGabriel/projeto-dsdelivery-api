package br.com.emanuelgabriel.exceptions;

public class RegraNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraNegocioException() {
	}

	public RegraNegocioException(String mensagem) {
		super(mensagem);
	}
}
