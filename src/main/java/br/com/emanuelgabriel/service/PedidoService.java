package br.com.emanuelgabriel.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.dto.request.PedidoInputModelRequest;
import br.com.emanuelgabriel.dto.request.ProdutoCodigoInputModelRequest;
import br.com.emanuelgabriel.dto.response.PedidoConfirmadoModelResponse;
import br.com.emanuelgabriel.dto.response.PedidoEntregaConfirmadaModelResponse;
import br.com.emanuelgabriel.dto.response.PedidoModelResponse;
import br.com.emanuelgabriel.dto.response.ProdutoParcialModelResponse;
import br.com.emanuelgabriel.exceptions.ObjetoNaoEncontradoException;
import br.com.emanuelgabriel.exceptions.PedidoNaoEncontradoException;
import br.com.emanuelgabriel.exceptions.ProdutoNaoEncontradoException;
import br.com.emanuelgabriel.exceptions.RegraNegocioException;
import br.com.emanuelgabriel.model.Pedido;
import br.com.emanuelgabriel.model.Produto;
import br.com.emanuelgabriel.model.enums.StatusPedido;
import br.com.emanuelgabriel.repository.PedidoRepository;
import br.com.emanuelgabriel.repository.ProdutoRepository;

@Service
public class PedidoService {

	private static final String PEDIDO_CODIGO_NAO_ENCONTRADO = "Pedido de código não encontrado";
	private static final String PRODUTO_CODIGO_NAO_ENCONTRADO = "Produto de código não encontrado";

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public PedidoInputModelRequest criar(PedidoInputModelRequest dto) {
		Pedido pedido = new Pedido(null, dto.getEndereco(), dto.getLatitude(), dto.getLongitude(), OffsetDateTime.now(),
				dto.getTaxaFrete(), StatusPedido.PENDENTE);

		for (ProdutoCodigoInputModelRequest p : dto.getProdutos()) {
			Optional<Produto> produto = this.produtoRepository.findById(p.getId());
			if (!produto.isPresent()) {
				throw new ProdutoNaoEncontradoException(PRODUTO_CODIGO_NAO_ENCONTRADO);
			}

			pedido.getProdutos().add(produto.get());
		}

		pedido.setTaxaFrete(dto.getTaxaFrete());
		pedido.setValorTotal(pedido.getValorTotal());
		pedido = this.pedidoRepository.save(pedido);

		return new PedidoInputModelRequest(pedido);
	}

	@Transactional
	public PedidoModelResponse salvar(PedidoModelResponse dto) {
		Pedido pedido = new Pedido(null, dto.getEndereco(), dto.getLatitude(), dto.getLongitude(), OffsetDateTime.now(),
				dto.getTaxaFrete(), StatusPedido.PENDENTE);

		for (ProdutoParcialModelResponse p : dto.getProdutos()) {
			Produto produto = this.produtoRepository.getOne(p.getId());
			if (produto == null) {
				throw new EntityNotFoundException(PEDIDO_CODIGO_NAO_ENCONTRADO);
			}

			pedido.getProdutos().add(produto);
		}

		pedido.setTaxaFrete(pedido.getTaxaFrete());
		pedido = this.pedidoRepository.save(pedido);

		return new PedidoModelResponse(pedido);
	}

	@Transactional(readOnly = true)
	public List<PedidoModelResponse> buscarTodos() {
		List<Pedido> pedidos = this.pedidoRepository.buscarPedidosProdutos();
		return pedidos.stream().map(p -> new PedidoModelResponse(p)).collect(Collectors.toList());
	}

	@Transactional
	public PedidoModelResponse buscarPorId(Long id) {
		Optional<Pedido> pedido = this.pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			throw new ObjetoNaoEncontradoException(PEDIDO_CODIGO_NAO_ENCONTRADO);
		}

		return new PedidoModelResponse(pedido.get());
	}

	@Transactional
	public PedidoEntregaConfirmadaModelResponse entregarPedido(Long idPedido) {
		Pedido pedido = buscarOuFalhar(idPedido);

		if (pedido.getStatusPedido() == StatusPedido.CONFIRMADO) {
			pedido.entregar();
			pedido = this.pedidoRepository.save(pedido);

		} else {
			throw new RegraNegocioException("O pedido deve está com o status de CONFIRMADO para a entrega");
		}

		return new PedidoEntregaConfirmadaModelResponse(pedido);
	}

	@Transactional
	public PedidoConfirmadoModelResponse confirmarPedido(Long idPedido) {
		Pedido pedido = buscarOuFalhar(idPedido);

		pedido.confirmar();
		pedido = this.pedidoRepository.save(pedido);
		return new PedidoConfirmadoModelResponse(pedido);
	}

	private Pedido buscarOuFalhar(Long codigoPedido) {
		return this.pedidoRepository.findById(codigoPedido)
				.orElseThrow(() -> new PedidoNaoEncontradoException(PEDIDO_CODIGO_NAO_ENCONTRADO));
	}
}
