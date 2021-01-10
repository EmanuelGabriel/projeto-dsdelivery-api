package br.com.emanuelgabriel.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException(String idProduto) {
		super(idProduto);
	}

}
