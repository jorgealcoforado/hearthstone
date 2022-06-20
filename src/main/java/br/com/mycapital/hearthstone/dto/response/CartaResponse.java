package br.com.mycapital.hearthstone.dto.response;

import br.com.mycapital.hearthstone.enums.Classe;
import br.com.mycapital.hearthstone.enums.Tipo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Schema(name = "Carta Response")
public class CartaResponse {

	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Integer ataque;
	
	private Integer defesa;
	
	private Tipo tipo;
	
	private Classe classe;
}
