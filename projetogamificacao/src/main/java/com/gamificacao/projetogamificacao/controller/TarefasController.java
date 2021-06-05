package com.gamificacao.projetogamificacao.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamificacao.projetogamificacao.models.Tarefa;
import com.gamificacao.projetogamificacao.repository.TarefaRepository;
import com.gamificacao.projetogamificacao.service.TarefasService;

@RestController
@CrossOrigin ("*")
@RequestMapping("/tarefa")
public class TarefasController {
	
	private @Autowired TarefasService tarefasService;
	private @Autowired TarefaRepository tarefaRepository;
	
	@PostMapping("/{id}")
	public ResponseEntity<?> adicionarTarefa(
			@Valid @RequestBody Tarefa tarefa, 
			@PathVariable(value = "id") Long idUser) {
		return tarefasService.criarTarefa(tarefa, idUser)
				.map(tarefaCriada -> ResponseEntity.status(HttpStatus.CREATED)
						.body(tarefaCriada))
				.orElse(ResponseEntity.status(400).build());	
	}
	
	@PutMapping
	public ResponseEntity<?> editarTarefa(@Valid @RequestBody Tarefa tarefaEditada){
		return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.save(tarefaEditada));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		tarefaRepository.deleteById(id);
	}
		
	@PutMapping("/confirmar/{id}")
	public ResponseEntity<?> confirmarTarefa (
			@PathVariable(value = "id") Long id){
		return tarefasService.confirmarTarefa(id)
				.map(confirmada -> ResponseEntity.status(HttpStatus.OK)
						.body(confirmada))
				.orElse(ResponseEntity.status(400).build());
	}
}
