package br.com.emanuelgabriel.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.emanuelgabriel.model.Pedido;

public class PedidoInputModelRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Campo endereço não pode ser vazio")
	private String endereco;

	@NotNull
	private Double latitude;

	@NotNull
	private Double longitude;

	private BigDecimal taxaFrete;

	@Valid
	@NotNull(message = "Lista de produtos não pode ser nulo")
	private List<ProdutoCodigoInputModelRequest> produtos = new ArrayList<>();

	public PedidoInputModelRequest() {
	}

	public PedidoInputModelRequest(String endereco, Double latitude, Double longitude, OffsetDateTime dataPedido,
			BigDecimal taxaFrete) {
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.taxaFrete = taxaFrete;
	}

	public PedidoInputModelRequest(Pedido pedido) {
		endereco = pedido.getEndereco();
		latitude = pedido.getLatitude();
		longitude = pedido.getLongitude();
		taxaFrete = pedido.getTaxaFrete();
		produtos = pedido.getProdutos().stream().map(p -> new ProdutoCodigoInputModelRequest(p))
				.collect(Collectors.toList());
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

	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}

	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}

	public List<ProdutoCodigoInputModelRequest> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoCodigoInputModelRequest> produtos) {
		this.produtos = produtos;
	}

}
