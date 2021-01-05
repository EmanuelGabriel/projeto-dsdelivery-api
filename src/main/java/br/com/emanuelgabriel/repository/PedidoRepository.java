package br.com.emanuelgabriel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.emanuelgabriel.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("SELECT DISTINCT p FROM Pedido p JOIN FETCH p.produtos WHERE p.statusPedido = 0 ORDER BY p.dataPedido ASC")
	List<Pedido> buscarPedidosProdutos();

}
