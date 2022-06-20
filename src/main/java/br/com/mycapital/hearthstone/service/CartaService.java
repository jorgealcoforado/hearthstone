package br.com.mycapital.hearthstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mycapital.hearthstone.domain.Carta;
import br.com.mycapital.hearthstone.dto.request.CartaRequest;
import br.com.mycapital.hearthstone.dto.response.CartaResponse;
import br.com.mycapital.hearthstone.enums.Classe;
import br.com.mycapital.hearthstone.enums.Tipo;
import br.com.mycapital.hearthstone.exception.BadRequestException;
import br.com.mycapital.hearthstone.exception.NotFoundException;
import br.com.mycapital.hearthstone.repository.CartaRepository;

@Service
public class CartaService {

	@Autowired
	private CartaRepository repository;
	
	@Autowired
	private ObjectMapper mapper;
	
	public CartaResponse inserir(CartaRequest request) {
		
		if(repository.existsByNomeAndAtaqueAndDefesaAndClasseAndTipo(request.getNome(), request.getAtaque(), request.getDefesa(), request.getClasse(), request.getTipo()))
			throw new BadRequestException("Carta já cadastrada.");
		
		Carta Carta = mapper.convertValue(request, Carta.class);
		
		CartaResponse response = mapper.convertValue(repository.save(Carta), CartaResponse.class);
		return response;
	}
	
	public List<CartaResponse> listarTodos(){
		List<CartaResponse> response = new ArrayList<>();
		List<Carta> Cartas = repository.findAll();
		Cartas.stream().forEach(b-> response.add(mapper.convertValue(b, CartaResponse.class)));
		return response;
	}
	
	public CartaResponse encontrar(Long id, String nome, Classe classe, Tipo tipo){
		Carta carta = repository.findByIdOrNomeOrClasseOrTipo(id,nome,classe,tipo).orElseThrow(()-> new NotFoundException("Carta não encontrada."));
		return mapper.convertValue(carta, CartaResponse.class);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
