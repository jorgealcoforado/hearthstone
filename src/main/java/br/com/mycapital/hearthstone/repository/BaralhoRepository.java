package br.com.mycapital.hearthstone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mycapital.hearthstone.domain.Baralho;
import br.com.mycapital.hearthstone.enums.Classe;

@Repository
public interface BaralhoRepository extends JpaRepository<Baralho, Long> {

	Optional<Baralho> findByIdOrNomeOrClasse(Long id, String nome, Classe classe);
	
	boolean existsByNomeAndClasse(String nome, Classe classe);
}
