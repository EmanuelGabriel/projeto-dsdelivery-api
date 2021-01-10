package br.com.emanuelgabriel.dto.response;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.emanuelgabriel.model.Fornecedor;

public class FornecedorParcialModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Campo ID não pode ser nulo")
	private Long id;

	public FornecedorParcialModelResponse() {
	}

	public FornecedorParcialModelResponse(Fornecedor fornecedor) {
		this.id = fornecedor.getId();
	}

	public FornecedorParcialModelResponse(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
