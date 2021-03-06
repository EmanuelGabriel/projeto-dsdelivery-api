package br.com.emanuelgabriel.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.emanuelgabriel.model.Produto;

public class ProdutoModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private BigDecimal precoUnitario;
	private Integer quantidadeEstoque;
	private String descricao;
	private String imagemUri;
	private List<FornecedorModelResponse> fornecedores = new ArrayList<>();

	public ProdutoModelResponse() {
	}

	public ProdutoModelResponse(Long id, String nome, BigDecimal precoUnitario, Integer quantidadeEstoque,
			String descricao, String imagemUri) {
		this.id = id;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidadeEstoque = quantidadeEstoque;
		this.descricao = descricao;
		this.imagemUri = imagemUri;
	}

	public ProdutoModelResponse(Produto produto) {
		id = produto.getId();
		nome = produto.getNome();
		precoUnitario = produto.getPrecoUnitario();
		quantidadeEstoque = produto.getQuantidade();
		descricao = produto.getDescricao();
		imagemUri = produto.getImagemUri();
		fornecedores = produto.getFornecedores().stream().map(f -> new FornecedorModelResponse(f))
				.collect(Collectors.toList());
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

	public List<FornecedorModelResponse> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorModelResponse> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
