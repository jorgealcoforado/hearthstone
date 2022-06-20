package br.com.mycapital.hearthstone.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.mycapital.hearthstone.enums.Classe;
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
@EqualsAndHashCode(callSuper=false, of={"nome","classe"})
@Table
public class Baralho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6028397981551495349L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "classe", nullable = true)
	private Classe classe;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="baralho_carta",
		joinColumns={@JoinColumn(name="baralho_id")},
		inverseJoinColumns={@JoinColumn(name="carta_id")})
	private List<Carta> cartas;
}
