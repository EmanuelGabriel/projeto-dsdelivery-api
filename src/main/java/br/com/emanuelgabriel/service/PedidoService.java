package br.com.emanuelgabriel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.dto.PedidoDTO;
import br.com.emanuelgabriel.model.Pedido;
import br.com.emanuelgabriel.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Transactional(readOnly = true)
	public List<PedidoDTO> buscarTodos() {
		List<Pedido> listaPedidos = this.pedidoRepository.buscarPedidosProdutos();
		return listaPedidos.stream().map(p -> new PedidoDTO(p)).collect(Collectors.toList());
	}

}
