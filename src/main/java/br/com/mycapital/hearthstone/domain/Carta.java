package br.com.mycapital.hearthstone.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.mycapital.hearthstone.enums.Classe;
import br.com.mycapital.hearthstone.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@EqualsAndHashCode(callSuper=false, of={"nome","ataque","defesa","tipo","classe"})
@Table
public class Carta implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1455677686656750437L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Integer ataque;
	
	@Column(nullable = false)
	private Integer defesa;
	
	@Column(nullable = false)
	private Tipo tipo;
	
	@Column(nullable = false)
	private Classe classe;
}
