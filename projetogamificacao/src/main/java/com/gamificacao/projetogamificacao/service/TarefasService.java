package com.gamificacao.projetogamificacao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.models.Atividades;
import com.gamificacao.projetogamificacao.models.Tarefa;
import com.gamificacao.projetogamificacao.repository.AtividadesRepository;
import com.gamificacao.projetogamificacao.repository.TarefaRepository;
import com.gamificacao.projetogamificacao.repository.UsuarioRepository;

@Service
public class TarefasService {
	
	private @Autowired TarefaRepository tarefaRepository;
	private @Autowired UsuarioRepository usuarioRepository;
	private @Autowired AtividadesRepository atividadeRepository;
	
	
	/**
	 * Cria uma tarefa e adiciona a atividades uma nova atividade do usuario.
	 * 
	 * @param novaTarefa uma Entidade Tarefa
	 * @param idUsuario tipo Long
	 * @return Optional com entidade Tarefa, caso usuario existente ou um Optional
	 *         vazio
	 * @since 1.0
	 * @author Rodrigo Teixeira
	 */
	public Optional<Tarefa> criarTarefa(Tarefa novaTarefa, Long idUsuario){
		return usuarioRepository.findById(idUsuario)
				.map(usuario -> {
					novaTarefa.setUsuarioResponsavel(usuario);
					Atividades atividade = new Atividades("teste", "teste", usuario);
					atividadeRepository.save(atividade);
					tarefaRepository.save(novaTarefa);
					return tarefaRepository.findById(novaTarefa.getId());
				}).orElse(Optional.empty());
	}
	
	
	/**
	 * Confirma uma tarefa muda seu status para true.
	 * 
	 * @param idTarefa tipo Long
	 * @return Optional com entidade Tarefa, caso usuario existente ou um Optional
	 *         vazio
	 * @since 1.0
	 * @author Rodrigo Teixeira
	 */
	public Optional<?> confirmarTarefa(Long idTarefa){
		return tarefaRepository.findById(idTarefa)
				.map(tarefa -> {
				tarefa.setStatus(true);
				tarefaRepository.save(tarefa);
				return Optional.of(tarefa);
				}).orElse(Optional.empty());
	}
	
}
