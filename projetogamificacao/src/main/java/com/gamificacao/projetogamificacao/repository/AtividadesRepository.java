package com.gamificacao.projetogamificacao.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.models.Atividades;

@Repository
public interface AtividadesRepository extends JpaRepository<Atividades, Long> {
	
	public Optional<Atividades> findByStatus (String status);

}
