package br.com.emanuelgabriel.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.emanuelgabriel.model.Pedido;
import br.com.emanuelgabriel.model.enums.StatusPedido;

public class PedidoModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String endereco;
	private Double latitude;
	private Double longitude;
	private OffsetDateTime dataPedido;
	private StatusPedido statusPedido;
	private BigDecimal taxaFrete;
	private BigDecimal valorTotal;
	private List<ProdutoParcialModelResponse> produtos = new ArrayList<>();

	public PedidoModelResponse() {
	}

	public PedidoModelResponse(Long id, String endereco, Double latitude, Double longitude, OffsetDateTime dataPedido,
			StatusPedido statusPedido, BigDecimal valorTotal, BigDecimal taxaFrete) {
		this.id = id;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
		this.taxaFrete = taxaFrete;
		this.valorTotal = valorTotal;
	}

	public PedidoModelResponse(Pedido pedido) {
		id = pedido.getId();
		endereco = pedido.getEndereco();
		latitude = pedido.getLatitude();
		longitude = pedido.getLongitude();
		dataPedido = pedido.getDataPedido();
		statusPedido = pedido.getStatusPedido();
		taxaFrete = pedido.getTaxaFrete();
		valorTotal = pedido.getTotal01();
		produtos = pedido.getProdutos().stream().map(prod -> new ProdutoParcialModelResponse(prod))
				.collect(Collectors.toList());
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

	public List<ProdutoParcialModelResponse> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoParcialModelResponse> produtos) {
		this.produtos = produtos;
	}

}
