package br.com.emanuelgabriel.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.emanuelgabriel.model.Produto;

public class ProdutoParcialModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private BigDecimal precoUnitario;
	private String descricao;
	private String imagemUri;

	public ProdutoParcialModelResponse() {
	}

	public ProdutoParcialModelResponse(Long id, String nome, BigDecimal precoUnitario, String descricao,
			String imagemUri) {
		this.id = id;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.descricao = descricao;
		this.imagemUri = imagemUri;
	}

	public ProdutoParcialModelResponse(Produto produto) {
		id = produto.getId();
		nome = produto.getNome();
		precoUnitario = produto.getPrecoUnitario();
		descricao = produto.getDescricao();
		imagemUri = produto.getImagemUri();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagemUri() {
		return imagemUri;
	}

	public void setImagemUri(String imagemUri) {
		this.imagemUri = imagemUri;
	}

}
