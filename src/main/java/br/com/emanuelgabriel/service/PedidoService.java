package br.com.emanuelgabriel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.dto.PedidoDTO;
import br.com.emanuelgabriel.dto.ProdutoDTO;
import br.com.emanuelgabriel.model.Pedido;
import br.com.emanuelgabriel.model.Produto;
import br.com.emanuelgabriel.model.enums.StatusPedido;
import br.com.emanuelgabriel.repository.PedidoRepository;
import br.com.emanuelgabriel.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional(readOnly = true)
	public List<PedidoDTO> buscarTodos() {
		List<Pedido> listaPedidos = this.pedidoRepository.buscarPedidosProdutos();
		return listaPedidos.stream().map(p -> new PedidoDTO(p)).collect(Collectors.toList());
	}

	@Transactional
	public PedidoDTO salvar(PedidoDTO dto) {
		Pedido pedido = new Pedido(null, dto.getEndereco(), dto.getLatitude(), dto.getLongitude(), LocalDateTime.now(),
				StatusPedido.PENDENTE);

		for (ProdutoDTO p : dto.getProdutos()) {
			Produto produto = this.produtoRepository.getOne(p.getId());
			pedido.getProdutos().add(produto);
		}

		pedido = this.pedidoRepository.save(pedido);

		return new PedidoDTO(pedido);
	}

}
