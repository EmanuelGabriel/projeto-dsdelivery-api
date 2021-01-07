package br.com.emanuelgabriel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.dto.response.PedidoModelResponse;
import br.com.emanuelgabriel.dto.response.ProdutoModelResponse;
import br.com.emanuelgabriel.model.Pedido;
import br.com.emanuelgabriel.model.Produto;
import br.com.emanuelgabriel.model.enums.StatusPedido;
import br.com.emanuelgabriel.repository.PedidoRepository;
import br.com.emanuelgabriel.repository.ProdutoRepository;

@Service
public class PedidoService {

	private static final String PEDIDO_CODIGO_NAO_ENCONTRADO = "Pedido de código não encontrado";

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional(readOnly = true)
	public List<PedidoModelResponse> buscarTodos() {
		List<Pedido> listaPedidos = this.pedidoRepository.buscarPedidosProdutos();
		return listaPedidos.stream().map(p -> new PedidoModelResponse(p)).collect(Collectors.toList());
	}

	@Transactional
	public PedidoModelResponse salvar(PedidoModelResponse dto) {
		Pedido pedido = new Pedido(null, dto.getEndereco(), dto.getLatitude(), dto.getLongitude(), LocalDateTime.now(),
				StatusPedido.PENDENTE);

		for (ProdutoModelResponse p : dto.getProdutos()) {
			Produto produto = this.produtoRepository.getOne(p.getId());
			pedido.getProdutos().add(produto);
		}

		pedido = this.pedidoRepository.save(pedido);

		return new PedidoModelResponse(pedido);
	}

	@Transactional
	public PedidoModelResponse pedidoEntregue(Long id) {
		Pedido pedido = this.pedidoRepository.getOne(id);
		if (pedido == null) {
			throw new EntityNotFoundException(PEDIDO_CODIGO_NAO_ENCONTRADO);
		}

		pedido.setStatusPedido(StatusPedido.ENTREGUE);
		pedido = this.pedidoRepository.save(pedido);
		return new PedidoModelResponse(pedido);
	}

}
