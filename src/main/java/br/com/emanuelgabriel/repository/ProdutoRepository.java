package br.com.emanuelgabriel.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.emanuelgabriel.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNomeContaining(String nome);
	
	@Query("SELECT p FROM Produto p JOIN FETCH p.fornecedores WHERE p.preco >= :precoInicial AND p.preco <= :precoFinal ORDER BY preco")
	List<Produto> findByPrecoValores(@Param("precoInicial") BigDecimal precoInicial, @Param("precoFinal") BigDecimal precoFinal);

	// trazer todos os produtos ordenados por nome de forma crescente ASC
	List<Produto> findAllByOrderByNomeAsc();

}
