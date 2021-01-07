package br.com.emanuelgabriel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.emanuelgabriel.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNomeContaining(String nome);

	// trazer todos os produtos ordenados por nome de forma crescente
	List<Produto> findAllByOrderByNomeAsc();

}
