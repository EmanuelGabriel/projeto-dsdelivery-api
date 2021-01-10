package br.com.emanuelgabriel.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.emanuelgabriel.model.Produto;

public class ProdutoCodigoInputModelRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Código do produto não pode ser nulo")
	private Long id;

	public ProdutoCodigoInputModelRequest() {
	}

	public ProdutoCodigoInputModelRequest(Produto produto) {
		this.id = produto.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
