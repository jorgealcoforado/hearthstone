package br.com.mycapital.hearthstone.resource;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

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

import br.com.mycapital.hearthstone.dto.request.CartaRequest;
import br.com.mycapital.hearthstone.dto.response.CartaResponse;
import br.com.mycapital.hearthstone.enums.Classe;
import br.com.mycapital.hearthstone.enums.Tipo;
import br.com.mycapital.hearthstone.service.CartaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/carta")
public class CartaResource {

	@Autowired
	private CartaService service;
	
	@Operation(summary = "Cadastrar um Carta")
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<CartaResponse> cadastrar(@Valid @RequestBody CartaRequest request){
		return ok(service.inserir(request));
	}
	
	@Operation(summary = "Listar todos as Cartas")
	@GetMapping("/todos")
	@ResponseStatus(HttpStatus.CREATED) 
	public @ResponseBody ResponseEntity<Collection<CartaResponse>> listarTodos(){
		return ok(service.listarTodos());
	}
	
	@Operation(summary = "Consultar Carta")
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED) 
	public @ResponseBody ResponseEntity<CartaResponse> encontrar(
			@Parameter(name = "id", description = "id") @RequestParam(value = "id", defaultValue = "") final Long id
			,@Parameter(name = "nome", description = "nome") @RequestParam(value = "nome", defaultValue = "") final String nome
			,@Parameter(name = "classe", description = "classe") @RequestParam(value = "classe", defaultValue = "") final Classe classe
			,@Parameter(name = "tipo", description = "tipo") @RequestParam(value = "tipo", defaultValue = "") final Tipo tipo
			){
		return ok(service.encontrar(id,nome,classe,tipo));
	}
	
	@Operation(summary = "Deletar uma carta")
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity delete(@Parameter(name = "id", required = true, description = "id") @PathVariable(value = "id") final Long id){
		service.delete(id);
		return noContent().build();
	}
}
