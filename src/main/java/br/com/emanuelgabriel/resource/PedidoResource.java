package br.com.emanuelgabriel.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanuelgabriel.dto.request.PedidoInputModelRequest;
import br.com.emanuelgabriel.dto.response.PedidoConfirmadoModelResponse;
import br.com.emanuelgabriel.dto.response.PedidoEntregaConfirmadaModelResponse;
import br.com.emanuelgabriel.dto.response.PedidoModelResponse;
import br.com.emanuelgabriel.service.PedidoService;

@RestController
@RequestMapping(value = "/v1/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoModelResponse>> buscarTodos() {
		List<PedidoModelResponse> lista = this.pedidoService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping
	public ResponseEntity<PedidoModelResponse> salvar(@Valid @RequestBody PedidoInputModelRequest dto) {
		dto = this.pedidoService.criar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@GetMapping("/{idPedido}")
	public ResponseEntity<PedidoModelResponse> buscarPorId(@PathVariable Long idPedido) {
		PedidoModelResponse dto = this.pedidoService.buscarPorId(idPedido);
		return dto != null ? ResponseEntity.ok().body(dto) : ResponseEntity.notFound().build();
	}

	@PatchMapping("/{idPedido}/status/confirmacao")
	public ResponseEntity<PedidoConfirmadoModelResponse> pedidoConfirmado(@PathVariable Long idPedido) {
		PedidoConfirmadoModelResponse dto = this.pedidoService.confirmarPedido(idPedido);
		return ResponseEntity.ok().body(dto);
	}

	@PutMapping("/{idPedido}/status/entrega")
	public ResponseEntity<PedidoEntregaConfirmadaModelResponse> entregaPedido(@PathVariable Long idPedido) {
		PedidoEntregaConfirmadaModelResponse dto = this.pedidoService.entregarPedido(idPedido);
		return ResponseEntity.ok().body(dto);
	}

}
