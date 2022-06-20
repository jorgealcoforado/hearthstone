package br.com.mycapital.hearthstone.resource;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.noContent;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mycapital.hearthstone.dto.request.BaralhoRequest;
import br.com.mycapital.hearthstone.dto.response.BaralhoResponse;
import br.com.mycapital.hearthstone.enums.Classe;
import br.com.mycapital.hearthstone.service.BaralhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/baralho")
public class BaralhoResource {

	@Autowired
	private BaralhoService service;
	
	@Operation(summary = "Cadastrar um baralho")
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<BaralhoResponse> cadastrar(@Valid @RequestBody BaralhoRequest request){
		return ok(service.inserir(request));
	}
	
	@Operation(summary = "Listar todos os baralhos")
	@GetMapping("/todos")
	@ResponseStatus(HttpStatus.CREATED) 
	public @ResponseBody ResponseEntity<Collection<BaralhoResponse>> listarTodos(){
		return ok(service.listarTodos());
	}
	
	@Operation(summary = "Consultar baralho")
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED) 
	public @ResponseBody ResponseEntity<BaralhoResponse> encontrar(
			@Parameter(name = "id", description = "id") @RequestParam(value = "id", defaultValue = "") final Long id
			,@Parameter(name = "nome", description = "nome") @RequestParam(value = "nome", defaultValue = "") final String nome
			,@Parameter(name = "classe", description = "classe") @RequestParam(value = "classe", defaultValue = "") final Classe classe
			){
		return ok(service.encontrar(id,nome,classe));
	}
	
	@Operation(summary = "Deletar um baralho")
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity delete(@Parameter(name = "id", required = true, description = "id") @PathVariable(value = "id") final Long id){
		service.delete(id);
		return noContent().build();
	}
	
	@Operation(summary = "Vincular uma carta")
	@PostMapping("/{baralhoId}/carta/{cartaId}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity vincularCarta(
			@Parameter(name = "baralhoId", required = true, description = "baralhoId") @PathVariable(value = "baralhoId") final Long baralhoId,
			@Parameter(name = "cartaId", required = true, description = "cartaId") @PathVariable(value = "cartaId") final Long cartaId){
		service.vincularCarta(baralhoId,cartaId);
		return noContent().build();
	}
	
}
