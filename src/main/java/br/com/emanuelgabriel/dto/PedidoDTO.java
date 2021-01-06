package br.com.emanuelgabriel.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.emanuelgabriel.model.Pedido;
import br.com.emanuelgabriel.model.enums.StatusPedido;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String endereco;
	private Double latitude;
	private Double longitude;
	private LocalDateTime dataPedido;
	private StatusPedido statusPedido;
	private List<ProdutoDTO> produtos = new ArrayList<>();

	public PedidoDTO() {
	}

	public PedidoDTO(Long id, String endereco, Double latitude, Double longitude, LocalDateTime dataPedido,
			StatusPedido statusPedido) {
		this.id = id;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dataPedido = dataPedido;
		this.statusPedido = statusPedido;
	}

	public PedidoDTO(Pedido pedido) {
		id = pedido.getId();
		endereco = pedido.getEndereco();
		latitude = pedido.getLatitude();
		longitude = pedido.getLongitude();
		dataPedido = pedido.getDataPedido();
		statusPedido = pedido.getStatusPedido();
		produtos = pedido.getProdutos().stream().map(p -> new ProdutoDTO(p)).collect(Collectors.toList());
		// produtos = pedido.getProdutos().stream().map(p -> new
		// ProdutoModelResponse(p)).collect(Collectors.toList());
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

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

}
