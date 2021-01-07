package br.com.emanuelgabriel.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.emanuelgabriel.dto.response.PedidoModelResponse;
import br.com.emanuelgabriel.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoModelResponse>> buscarTodos() {
		List<PedidoModelResponse> lista = this.pedidoService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PedidoModelResponse> salvar(@Valid @RequestBody PedidoModelResponse dto) {

		dto = this.pedidoService.salvar(dto);
		URI location = getUri(dto.getId());
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{idPedido}/entregue")
	public ResponseEntity<PedidoModelResponse> entregaPedido(@PathVariable Long idPedido) {
		PedidoModelResponse dto = this.pedidoService.pedidoEntregue(idPedido);
		return ResponseEntity.ok().body(dto);
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}
