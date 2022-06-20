package br.com.mycapital.hearthstone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mycapital.hearthstone.domain.Carta;
import br.com.mycapital.hearthstone.enums.Classe;
import br.com.mycapital.hearthstone.enums.Tipo;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {

	Optional<Carta> findByIdOrNomeOrClasseOrTipo(Long id, String nome, Classe classe, Tipo tipo);
	
	boolean existsByNomeAndAtaqueAndDefesaAndClasseAndTipo(String nome, Integer ataque, Integer defesa, Classe classe, Tipo tipo);
}
