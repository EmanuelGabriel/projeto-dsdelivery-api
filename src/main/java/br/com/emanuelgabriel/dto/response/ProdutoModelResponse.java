package br.com.emanuelgabriel.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.emanuelgabriel.model.Produto;

public class ProdutoModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private BigDecimal preco;
	private String descricao;
	private String imagemUri;

	public ProdutoModelResponse() {
	}

	public ProdutoModelResponse(String nome, BigDecimal preco, String descricao, String imagemUri) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imagemUri = imagemUri;
	}

	public ProdutoModelResponse(Produto produto) {
		nome = produto.getNome();
		preco = produto.getPreco();
		descricao = produto.getDescricao();
		imagemUri = produto.getImagemUri();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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
