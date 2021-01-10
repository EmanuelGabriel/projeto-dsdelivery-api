package br.com.emanuelgabriel.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.dto.request.ProdutoInputModelRequest;
import br.com.emanuelgabriel.dto.response.FornecedorParcialModelResponse;
import br.com.emanuelgabriel.dto.response.ProdutoModelResponse;
import br.com.emanuelgabriel.exceptions.ObjetoNaoEncontradoException;
import br.com.emanuelgabriel.exceptions.ProdutoNaoEncontradoException;
import br.com.emanuelgabriel.model.Fornecedor;
import br.com.emanuelgabriel.model.Produto;
import br.com.emanuelgabriel.repository.FornecedorRepository;
import br.com.emanuelgabriel.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private static final String PRODUTO_COD_NAO_ENCONTRADO = "Produto de código não encontrado";
	private static final String NOME_PRODUTO_NAO_ENCONTRADO = "Produto de nome não encontrado";
	private static final String NENHUM_PRODUTO_ENCONTRADO = "Nenhum produto encontrado";
	private static final String NOME_PRODUTO_OU_DESCRICAO_NAO_ENCONTRADO = "Nome do produto ou descrição não encontrado";

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Transactional
	public ProdutoModelResponse salvar(ProdutoInputModelRequest requestProduto) {

		Produto produto = new Produto(requestProduto.getNome(), requestProduto.getPrecoUnitario(),
				requestProduto.getQuantidadeEstoque(), requestProduto.getDescricao(), requestProduto.getImagemUri());

		for (FornecedorParcialModelResponse fpr : requestProduto.getFornecedores()) {
			Fornecedor fornecedor = this.fornecedorRepository.getOne(fpr.getId());
			produto.getFornecedores().add(fornecedor);
		}

		produto = this.produtoRepository.save(produto);

		return new ProdutoModelResponse(produto);

	}

	@Transactional(readOnly = true)
	public List<ProdutoModelResponse> buscarTodos() {
		List<Produto> listaProdutos = this.produtoRepository.findAllByOrderByNomeAsc();
		return listaProdutos.stream().map(p -> new ProdutoModelResponse(p)).collect(Collectors.toList());
	}

	@Transactional
	public ProdutoModelResponse buscarPorId(Long id) {
		Optional<Produto> produto = this.produtoRepository.findById(id);
		if (!produto.isPresent()) {
			throw new ObjetoNaoEncontradoException(PRODUTO_COD_NAO_ENCONTRADO);
		}

		return new ProdutoModelResponse(produto.get());
	}

	@Transactional
	public List<ProdutoModelResponse> buscarPorNome(String nome) {
		List<Produto> produtos = this.produtoRepository.findByNomeIgnoreCaseContaining(nome);
		if (produtos.isEmpty()) {
			throw new ObjetoNaoEncontradoException(NOME_PRODUTO_NAO_ENCONTRADO);
		}
		return produtos.stream().map(prod -> new ProdutoModelResponse(prod)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<ProdutoModelResponse> buscarPorNomeDescricao(String nome, String descricao) {
		List<Produto> produtos = this.produtoRepository
				.findByNomeIgnoreCaseContainingOrDescricaoIgnoreCaseContaining(nome, descricao);
		if (produtos.isEmpty()) {
			throw new ObjetoNaoEncontradoException(NOME_PRODUTO_OU_DESCRICAO_NAO_ENCONTRADO);
		}

		return produtos.stream().map(prod -> new ProdutoModelResponse(prod)).collect(Collectors.toList());
	}

	@Transactional
	public List<ProdutoModelResponse> buscarPrecosProdutos(BigDecimal precoInicial, BigDecimal precoFinal) {
		List<Produto> produtos = this.produtoRepository.findByPrecoValores(precoInicial, precoFinal);
		if (produtos.isEmpty()) {
			throw new ObjetoNaoEncontradoException(NENHUM_PRODUTO_ENCONTRADO);
		}

		return produtos.stream().map(prod -> new ProdutoModelResponse(prod)).collect(Collectors.toList());
	}

	public Produto buscarOuFalhar(Long idProduto) {
		return this.produtoRepository.findById(idProduto)
				.orElseThrow(() -> new ProdutoNaoEncontradoException(PRODUTO_COD_NAO_ENCONTRADO));
	}

}
