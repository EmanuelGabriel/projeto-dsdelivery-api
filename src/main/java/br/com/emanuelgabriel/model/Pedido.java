package br.com.emanuelgabriel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import br.com.emanuelgabriel.model.enums.StatusPedido;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private BigDecimal subtotal;

	private BigDecimal taxaFrete;

	private BigDecimal valorTotal;

	@CreationTimestamp
	@Column(name = "data_pedido")
	private OffsetDateTime dataPedido;

	@Column(name = "data_confirmacao")
	private OffsetDateTime dataConfirmacao;

	@Column(name = "data_entrega")
	private OffsetDateTime dataEntrega;

	@Column(name = "status_pedido", length = 20)
	private StatusPedido statusPedido;

	@Column(nullable = false, length = 90)
	private String endereco;

	private Double latitude;

	private Double longitude;

	@ManyToMany
	@JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private Set<Produto> produtos = new HashSet<>();

	public Pedido() {
	}

	public Pedido(Long id, String endereco, Double latitude, Double longitude, OffsetDateTime dataPedido,
			BigDecimal taxaFrete, StatusPedido statusPedido) {
		this.id = id;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dataPedido = dataPedido;
		this.taxaFrete = taxaFrete;
		this.statusPedido = statusPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public OffsetDateTime getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(OffsetDateTime dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public OffsetDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(OffsetDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}

	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (Produto p : produtos) {
			soma = soma.add(p.getPrecoUnitario());
		}

		return soma;
	}

	public BigDecimal getTotal01() {
		getProdutos().forEach(Produto::calcularPrecoTotal);
		this.subtotal = getProdutos().stream().map(p -> p.getPrecoUnitario()).reduce(BigDecimal.ZERO, BigDecimal::add);
		this.valorTotal = this.subtotal.add(this.taxaFrete);
		return valorTotal;
	}

	public BigDecimal getTotal02() {
		getProdutos().forEach(Produto::calcularPrecoTotal);

		this.subtotal = getProdutos().stream().map(p -> p.getPrecoTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);

		this.valorTotal = this.subtotal; // .add(this.taxaFrete);

		return valorTotal;

	}

	/**
	 * Calcula o valor total do Pedido - private
	 */
	public void getcalcularValorTotal() {
		getProdutos().forEach(Produto::calcularPrecoTotal);

		this.subtotal = getProdutos().stream().map(p -> p.getPrecoTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);

		this.valorTotal = this.subtotal.add(this.taxaFrete);

	}

	/**
	 * Confirmar o Pedido
	 */
	public void confirmar() {
		if(statusPedido == StatusPedido.ENTREGUE) {
			 return;	
		}
		
		setStatusPedido(StatusPedido.CONFIRMADO);
		setDataConfirmacao(OffsetDateTime.now());
	}

	/**
	 * Confirmar a entrega do Pedido
	 */
	public void entregar() {
		setStatusPedido(StatusPedido.ENTREGUE);
		setDataEntrega(OffsetDateTime.now());
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
