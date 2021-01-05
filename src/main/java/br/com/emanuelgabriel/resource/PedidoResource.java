package br.com.emanuelgabriel.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanuelgabriel.dto.PedidoDTO;
import br.com.emanuelgabriel.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> buscarTodos() {
		List<PedidoDTO> lista = this.pedidoService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

}
