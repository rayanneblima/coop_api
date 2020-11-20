package br.com.coop.coop_api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.coop.coop_api.entities.UsuarioOng;

public interface UsuarioOngRepository extends JpaRepository<UsuarioOng, Integer> {
	Optional<UsuarioOng> findByEmail(String email);

	Page<UsuarioOng> findByEstado(String uf, Pageable paginacao);
	
	Page<UsuarioOng> findByEstadoAndCidade(String uf, String cidade, Pageable paginacao);	
	
	String queryDadosOng = "SELECT id_ong, email_ong, senha_ong, whatsapp_ong, sobre_ong, area_atuacao_ong, facebook_ong, instagram_ong, "
			+ "logradouro_local_ong, numero_local_ong, complemento_local_ong, cep_local_ong, estado_local_ong, cidade_local_ong	FROM usuario_ong ";
	
	@Query(value = queryDadosOng, nativeQuery= true)
	List<Object[]> buscaDadosOng();
	
	String queryItensOng = "SELECT id_ong, itens_doacao_requeridos FROM usuario_ong ";
	
	@Query(value = queryDadosOng, nativeQuery= true)
	List<Object[]> buscaItensOng();
	
}
