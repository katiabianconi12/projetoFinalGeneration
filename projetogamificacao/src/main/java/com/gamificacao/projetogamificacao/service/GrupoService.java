package com.gamificacao.projetogamificacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.models.Aprovacao;
import com.gamificacao.projetogamificacao.models.Grupo;
import com.gamificacao.projetogamificacao.models.InscricaoGrupo;
import com.gamificacao.projetogamificacao.repository.GrupoRepository;
import com.gamificacao.projetogamificacao.repository.InscricaoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	@Autowired
	private InscricaoRepository inscricaoRepository;

	public void aceitarUsuario(Long id) {
		Optional<InscricaoGrupo> inscricao = inscricaoRepository.findById(id);
		inscricao.get().setAprovacao(Aprovacao.APROVADO);
		inscricaoRepository.save(inscricao.get());

	}
	
	public void rejeitarUsuario(Long id) {
		Optional<InscricaoGrupo> inscricao = inscricaoRepository.findById(id);
		inscricao.get().setAprovacao(Aprovacao.NEGADO);
		inscricaoRepository.save(inscricao.get());

	}

	public Optional<List <Grupo>> buscarGrupo(String nome) {
		List<Grupo> resultado= grupoRepository.findByNomeContainingIgnoreCase(nome);
		return Optional.ofNullable(resultado);
	}
	

}
