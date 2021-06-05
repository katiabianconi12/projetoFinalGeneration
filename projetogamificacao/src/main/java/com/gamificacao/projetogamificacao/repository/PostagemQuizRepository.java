package com.gamificacao.projetogamificacao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.models.PostagemQuiz;

@Repository
public interface PostagemQuizRepository extends JpaRepository<PostagemQuiz, Long> {
	

}
