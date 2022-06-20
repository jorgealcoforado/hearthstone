package br.com.mycapital.hearthstone.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.mycapital.hearthstone.enums.Classe;
import br.com.mycapital.hearthstone.enums.Tipo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Schema(name = "Carta Request")
public class CartaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7702914253917293513L;

	@NotEmpty
	@Schema(required = true)
	private String nome;
	
	@NotEmpty
	@Schema(required = true)
	private String descricao;
	
	@NonNull
	@Schema(required = true)
	private Integer ataque;
	
	@NonNull
	@Schema(required = true)
	private Integer defesa;
	
	@NonNull
	@Schema(required = true)
	private Tipo tipo;
	
	@NonNull
	@Schema(required = true)
	private Classe classe;
	
}
