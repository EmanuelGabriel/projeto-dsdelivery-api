package br.com.emanuelgabriel.dto.response;

import java.io.Serializable;

import br.com.emanuelgabriel.model.Fornecedor;

public class FornecedorModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	public FornecedorModelResponse() {
	}

	public FornecedorModelResponse(String nome, String descricao) {
		this.nome = nome;
	}

	public FornecedorModelResponse(Fornecedor fornecedor) {
		this.nome = fornecedor.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
