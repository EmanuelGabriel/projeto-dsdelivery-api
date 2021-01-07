package br.com.emanuelgabriel.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.emanuelgabriel.model.Produto;

public class ProdutoInputModelRequest {

	@NotBlank(message = "Campo nome é obrigatório")
	private String nome;

	private BigDecimal preco;

	@NotBlank(message = "Campo descrição é obrigatório")
	private String descricao;

	@NotBlank(message = "A URI da imagem é obrigatório")
	private String imagemUri;

	public ProdutoInputModelRequest() {
	}

	public ProdutoInputModelRequest(String nome, BigDecimal preco, String descricao, String imagemUri) {
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
