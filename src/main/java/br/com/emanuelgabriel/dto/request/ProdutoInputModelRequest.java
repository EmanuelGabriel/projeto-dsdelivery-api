package br.com.emanuelgabriel.dto.request;

import java.math.BigDecimal;

import br.com.emanuelgabriel.model.Produto;

public class ProdutoInputModelRequest {

	private String nome;
	private BigDecimal preco;
	private String descricao;
	private String imagemUri;

	public ProdutoInputModelRequest() {
	}

	public ProdutoInputModelRequest(String nome, BigDecimal preco, String descricao, String imagemUri) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imagemUri = imagemUri;
	}

	public ProdutoInputModelRequest(Produto produto) {
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
