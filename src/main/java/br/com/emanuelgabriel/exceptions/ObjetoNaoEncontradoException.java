package br.com.emanuelgabriel.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException() {
	}

	public ObjetoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
