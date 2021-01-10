package br.com.emanuelgabriel.dto.response;

import java.io.Serializable;
import java.time.OffsetDateTime;

import br.com.emanuelgabriel.model.Pedido;
import br.com.emanuelgabriel.model.enums.StatusPedido;

public class PedidoEntregaConfirmadaModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private OffsetDateTime dataEntrega;
	private StatusPedido statusPedido;

	public PedidoEntregaConfirmadaModelResponse() {
	}

	public PedidoEntregaConfirmadaModelResponse(OffsetDateTime dataEntrega, StatusPedido statusPedido) {
		this.dataEntrega = dataEntrega;
		this.statusPedido = statusPedido;
	}

	public PedidoEntregaConfirmadaModelResponse(Pedido pedido) {
		this.dataEntrega = pedido.getDataEntrega();
		this.statusPedido = pedido.getStatusPedido();
	}

	public OffsetDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(OffsetDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

}
