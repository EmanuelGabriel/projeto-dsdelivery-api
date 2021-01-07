package br.com.emanuelgabriel.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.emanuelgabriel.dto.response.ProdutoModelResponse;
import br.com.emanuelgabriel.model.Pedido;

public class PedidoInputModelRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String endereco;
	private Double latitude;
	private Double longitude;
	private LocalDateTime dataPedido;
	private List<ProdutoModelResponse> produtos = new ArrayList<>();

	public PedidoInputModelRequest() {
	}

	public PedidoInputModelRequest(String endereco, Double latitude, Double longitude, LocalDateTime dataPedido) {
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dataPedido = dataPedido;
	}

	public PedidoInputModelRequest(Pedido pedido) {
		endereco = pedido.getEndereco();
		latitude = pedido.getLatitude();
		longitude = pedido.getLongitude();
		dataPedido = pedido.getDataPedido();
		produtos = pedido.getProdutos().stream().map(p -> new ProdutoModelResponse(p)).collect(Collectors.toList());
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

	public List<ProdutoModelResponse> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModelResponse> produtos) {
		this.produtos = produtos;
	}

}
