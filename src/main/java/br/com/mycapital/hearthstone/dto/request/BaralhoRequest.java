package br.com.mycapital.hearthstone.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.mycapital.hearthstone.enums.Classe;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Schema(name = "Baralho Request")
public class BaralhoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7702914253917293513L;

	@NotEmpty
	@Schema(description = "nome", required = true)
	private String nome;
	
	@NotNull
	@Schema(description = "classe", required = true)
	private Classe classe;
}
