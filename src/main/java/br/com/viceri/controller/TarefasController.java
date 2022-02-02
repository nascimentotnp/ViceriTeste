package br.com.viceri.controller;

import br.com.viceri.dto.request.TarefaForm;
import br.com.viceri.dto.response.DetalhesDaTarefaDto;
import br.com.viceri.dto.response.TarefaDto;
import br.com.viceri.entity.Tarefa;
import br.com.viceri.enums.PrioridadeEnum;
import br.com.viceri.service.TarefaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping
	public Page<TarefaDto> listar(@RequestParam(required = false) PrioridadeEnum prioridade, @RequestHeader HttpHeaders headers,
								  @PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		List<String> authorization = headers.get("Authorization");
		assert authorization != null;
		return tarefaService.listar(prioridade, authorization.get(0), paginacao);
	}

	@PostMapping
	public ResponseEntity<TarefaDto> cadastrar(@RequestBody @Valid TarefaForm form, @RequestHeader HttpHeaders headers) {
		List<String> authorization = headers.get("Authorization");
		assert authorization != null;
		return new ResponseEntity<>(tarefaService.cadastrar(form, authorization.get(0)), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDaTarefaDto> detalhar(@PathVariable Long id) {
		Optional<Tarefa> tarefa = tarefaService.findById(id);
		return tarefa.map(value -> ResponseEntity.ok(new DetalhesDaTarefaDto(value))).orElseGet(() -> ResponseEntity.notFound().build());

	}

	@PutMapping("/{id}")
	public ResponseEntity<TarefaDto> atualizar(@PathVariable Long id, @RequestBody @Valid TarefaForm form) {
		try{
			return ResponseEntity.ok().body(tarefaService.update(id, form));
		}catch (NotFoundException e){
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		try{
			tarefaService.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (EmptyResultDataAccessException e){
			return ResponseEntity.notFound().build();
		}
	}

}