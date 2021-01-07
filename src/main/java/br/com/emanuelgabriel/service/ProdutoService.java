package br.com.emanuelgabriel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.dto.request.ProdutoInputModelRequest;
import br.com.emanuelgabriel.dto.response.ProdutoModelResponse;
import br.com.emanuelgabriel.exceptions.ObjetoNaoEncontradoException;
import br.com.emanuelgabriel.model.Produto;
import br.com.emanuelgabriel.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private static final String PRODUTO_COD_NAO_ENCONTRADO = "Produto de código não encontrado";
	private static final String NOME_PRODUTO_NAO_ENCONTRADO = "Produto de nome não encontrado";

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public ProdutoModelResponse salvar(ProdutoInputModelRequest requestProduto) {

		Produto produto = new Produto(requestProduto.getNome(), requestProduto.getPreco(),
				requestProduto.getDescricao(), requestProduto.getImagemUri());

		produto = this.produtoRepository.save(produto);

		return new ProdutoModelResponse(produto);

	}

	@Transactional(readOnly = true)
	public List<ProdutoModelResponse> buscarTodos() {
		List<Produto> listaProdutos = this.produtoRepository.findAllByOrderByNomeAsc();
		return listaProdutos.stream().map(p -> new ProdutoModelResponse(p)).collect(Collectors.toList());
	}

	public ProdutoModelResponse buscarPorId(Long id) {
		Optional<Produto> produto = this.produtoRepository.findById(id);
		if (!produto.isPresent()) {
			throw new ObjetoNaoEncontradoException(PRODUTO_COD_NAO_ENCONTRADO);
		}

		return new ProdutoModelResponse(produto.get());
	}

	public List<ProdutoModelResponse> buscarPorNome(String nome) {
		List<Produto> produtos = this.produtoRepository.findByNomeContaining(nome);
		if (produtos.isEmpty()) {
			throw new ObjetoNaoEncontradoException(NOME_PRODUTO_NAO_ENCONTRADO);
		}
		return produtos.stream().map(prod -> new ProdutoModelResponse(prod)).collect(Collectors.toList());
	}

}
