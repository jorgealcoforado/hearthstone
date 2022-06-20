package br.com.mycapital.hearthstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mycapital.hearthstone.domain.Baralho;
import br.com.mycapital.hearthstone.domain.Carta;
import br.com.mycapital.hearthstone.dto.request.BaralhoRequest;
import br.com.mycapital.hearthstone.dto.response.BaralhoResponse;
import br.com.mycapital.hearthstone.enums.Classe;
import br.com.mycapital.hearthstone.exception.BadRequestException;
import br.com.mycapital.hearthstone.exception.NotFoundException;
import br.com.mycapital.hearthstone.repository.BaralhoRepository;
import br.com.mycapital.hearthstone.repository.CartaRepository;
import br.com.mycapital.hearthstone.util.DomainUtil;

@Service
public class BaralhoService {

	@Autowired
	private BaralhoRepository repository;
	
	@Autowired
	private CartaRepository cartaRepository; 
	
	@Autowired
	private ObjectMapper mapper;
	
	public BaralhoResponse inserir(BaralhoRequest request) {
		
		if(repository.existsByNomeAndClasse(request.getNome(), request.getClasse()))
			throw new BadRequestException("Baralho já cadastrado.");
		
		Baralho baralho = mapper.convertValue(request, Baralho.class);
		BaralhoResponse response = mapper.convertValue(repository.save(baralho), BaralhoResponse.class);
		return response;
	}
	
	public List<BaralhoResponse> listarTodos(){
		List<BaralhoResponse> response = new ArrayList<>();
		List<Baralho> baralhos = repository.findAll();
		baralhos.stream().forEach(b-> response.add(mapper.convertValue(b, BaralhoResponse.class)));
		return response;
	}
	
	public BaralhoResponse encontrar(Long id, String nome, Classe classe){
		Baralho baralho = repository.findByIdOrNomeOrClasse(id,nome,classe).orElseThrow(()-> new NotFoundException("Baralho não encontrado."));
		return mapper.convertValue(baralho, BaralhoResponse.class);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public void vincularCarta(Long baralhoId, Long cartaId) {
		Baralho baralho = repository.findById(baralhoId).orElseThrow(()-> new NotFoundException("Baralho não encontrado."));
		
		Carta carta = cartaRepository.findById(cartaId).orElseThrow(()-> new NotFoundException("Carta não encontrada."));
		
		if(DomainUtil.notIn(carta.getClasse(), baralho.getClasse(), Classe.QUALQUER))
			throw new BadRequestException("A carta deve ser da mesma classe do baralho ou classe 'QUALQUER'.");
		
		if(!Optional.ofNullable(baralho.getCartas()).isEmpty()
				&& baralho.getCartas().size()>30)
			throw new BadRequestException("Quantidade máxima de cartas no baralho: 30.");
		
		if(baralho.getCartas().stream().filter(c-> c.equals(carta)).count()>1)
			throw new BadRequestException("Quantidade máxima de cartas iguais no mesmo baralho: 2. ");
		
		baralho.getCartas().add(carta);
		repository.save(baralho);
	}
}
