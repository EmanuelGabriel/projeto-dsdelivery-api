package br.com.emanuelgabriel.exceptions;

public class FornecedorNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FornecedorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
