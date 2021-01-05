package br.com.emanuelgabriel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.dto.ProdutoDTO;
import br.com.emanuelgabriel.dto.request.ProdutoInputModelRequest;
import br.com.emanuelgabriel.model.Produto;
import br.com.emanuelgabriel.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public ProdutoDTO salvar(ProdutoInputModelRequest request) {

		Produto produto = new Produto(request.getNome(), request.getPreco(), request.getDescricao(),
				request.getImagemUri());

		produto = this.produtoRepository.save(produto);

		return new ProdutoDTO(produto);

	}

	@Transactional(readOnly = true)
	public List<ProdutoDTO> buscarTodos() {
		List<Produto> listaProdutos = this.produtoRepository.findAllByOrderByNomeAsc();
		return listaProdutos.stream().map(p -> new ProdutoDTO(p)).collect(Collectors.toList());
	}

}
