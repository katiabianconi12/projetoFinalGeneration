package com.gamificacao.projetogamificacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.models.AprovacaoAmigos;

@Repository
public interface AprovacaoAmigosRepository extends JpaRepository<AprovacaoAmigos, Long> {

}
