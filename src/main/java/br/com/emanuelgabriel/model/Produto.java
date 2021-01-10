package br.com.emanuelgabriel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(nullable = false, length = 60)
	private String nome;

	@Column(name = "preco_unitario")
	private BigDecimal precoUnitario;

	@Column(name = "preco_total")
	private BigDecimal precoTotal;

	private Integer quantidade;

	@Column(length = 100)
	private String descricao;

	@Column(name = "imagem_uri")
	private String imagemUri;

	@OneToMany
	@JoinColumn(name = "produto_id")
	private List<Fornecedor> fornecedores = new ArrayList<>();

	public Produto() {
	}

	public Produto(Long id, String nome, BigDecimal precoUnitario, BigDecimal precoTotal, Integer quantidade,
			String descricao, String imagemUri) {
		this.id = id;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.precoTotal = precoTotal;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.imagemUri = imagemUri;
	}

	public Produto(String nome, BigDecimal precoUnitario, Integer quantidade, String descricao, String imagemUri) {
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.imagemUri = imagemUri;
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

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	/**
	 * Calcula o preço total do Produtos
	 */
	public void calcularPrecoTotal() {

		BigDecimal precoUnitario = this.getPrecoUnitario();
		Integer quantidade = this.getQuantidade();

		if (precoUnitario == null) {
			precoUnitario = BigDecimal.ZERO;
		}

		if (quantidade == null) {
			quantidade = 0;
		}

		this.setPrecoTotal(precoUnitario.multiply(new BigDecimal(quantidade)));

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
