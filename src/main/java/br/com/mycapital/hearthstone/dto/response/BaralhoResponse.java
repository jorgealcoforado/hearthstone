package br.com.mycapital.hearthstone.dto.response;

import java.util.List;

import br.com.mycapital.hearthstone.domain.Carta;
import br.com.mycapital.hearthstone.enums.Classe;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Schema(name = "Baralho Response")
public class BaralhoResponse {

	private Long id;
	
	private String nome;
	
	private Classe classe;
	
	private List<Carta> cartas;
}
