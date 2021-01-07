package br.com.emanuelgabriel.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.emanuelgabriel.dto.request.ProdutoInputModelRequest;
import br.com.emanuelgabriel.dto.response.ProdutoModelResponse;
import br.com.emanuelgabriel.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProdutoModelResponse> salvar(@Valid @RequestBody ProdutoInputModelRequest request) {
		ProdutoModelResponse dto = this.produtoService.salvar(request);
		URI location = getUri(dto.getId());
		return ResponseEntity.created(location).build();
	}

	@GetMapping
	public ResponseEntity<List<ProdutoModelResponse>> buscarTodos() {
		List<ProdutoModelResponse> lista = this.produtoService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{idProduto}")
	public ResponseEntity<ProdutoModelResponse> buscarPorId(@PathVariable Long idProduto) {
		ProdutoModelResponse produto = this.produtoService.buscarPorId(idProduto);
		return produto != null ? ResponseEntity.ok().body(produto) : ResponseEntity.notFound().build();
	}

	@GetMapping("/buscar-nome")
	public ResponseEntity<List<ProdutoModelResponse>> buscarPorNome(@PathParam("nomeProduto") String nomeProduto) {
		List<ProdutoModelResponse> produtos = this.produtoService.buscarPorNome(nomeProduto);
		return produtos != null ? ResponseEntity.ok().body(produtos) : ResponseEntity.notFound().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}
