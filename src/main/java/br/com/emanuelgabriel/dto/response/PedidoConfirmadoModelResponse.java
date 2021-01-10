package br.com.emanuelgabriel.dto.response;

import java.io.Serializable;
import java.time.OffsetDateTime;

import br.com.emanuelgabriel.model.Pedido;
import br.com.emanuelgabriel.model.enums.StatusPedido;

public class PedidoConfirmadoModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private OffsetDateTime dataPedido;
	private OffsetDateTime dataConfirmacao;
	private StatusPedido statusPedido;

	public PedidoConfirmadoModelResponse() {
	}

	public PedidoConfirmadoModelResponse(OffsetDateTime dataPedido, OffsetDateTime dataConfirmacao,
			StatusPedido statusPedido) {
		this.dataPedido = dataPedido;
		this.dataConfirmacao = dataConfirmacao;
		this.statusPedido = statusPedido;
	}

	public PedidoConfirmadoModelResponse(Pedido pedido) {
		this.dataPedido = pedido.getDataPedido();
		this.dataConfirmacao = pedido.getDataConfirmacao();
		this.statusPedido = pedido.getStatusPedido();
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public OffsetDateTime getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(OffsetDateTime dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

}
