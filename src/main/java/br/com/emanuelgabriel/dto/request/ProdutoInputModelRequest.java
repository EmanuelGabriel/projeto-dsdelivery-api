package br.com.emanuelgabriel.dto.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.emanuelgabriel.dto.response.FornecedorParcialModelResponse;
import br.com.emanuelgabriel.model.Produto;

public class ProdutoInputModelRequest {

	@NotBlank(message = "Campo nome é obrigatório")
	private String nome;

	@NotNull(message = "Preço unitário não pode ser nulo")
	@Positive(message = "Campo preço unitário não pode ser zero")
	private BigDecimal precoUnitario;

	@NotNull(message = "Quantidade de estoque não pode ser nulo")
	private Integer quantidadeEstoque;

	@NotBlank(message = "Campo descrição é obrigatório")
	private String descricao;

	@NotBlank(message = "A URI da imagem é obrigatório")
	private String imagemUri;

	@NotEmpty(message = "Lista de fornecedores não pode está vazia")
	@NotNull(message = "Lista de fornecedores não pode ser nulo")
	private List<FornecedorParcialModelResponse> fornecedores = new ArrayList<>();

	public ProdutoInputModelRequest() {
	}

	public ProdutoInputModelRequest(String nome, BigDecimal precoUnitario, Integer quantidadeEstoque, String descricao,
			String imagemUri) {
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidadeEstoque = quantidadeEstoque;
		this.descricao = descricao;
		this.imagemUri = imagemUri;
	}

	public ProdutoInputModelRequest(Produto produto) {
		nome = produto.getNome();
		precoUnitario = produto.getPrecoUnitario();
		quantidadeEstoque = produto.getQuantidade();
		descricao = produto.getDescricao();
		imagemUri = produto.getImagemUri();
		fornecedores = produto.getFornecedores().stream().map(f -> new FornecedorParcialModelResponse(f))
				.collect(Collectors.toList());
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

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
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

	public List<FornecedorParcialModelResponse> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorParcialModelResponse> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
