package com.gamificacao.projetogamificacao.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_inscricao")
public class InscricaoGrupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Enumerated (EnumType.STRING)
	private Aprovacao aprovacao;
		
	

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioInscricao; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "grupo_id")
	private Grupo grupoInscricao;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuarioInscricao() {
		return usuarioInscricao;
	}

	public void setUsuarioInscricao(Usuario usuarioInscricao) {
		this.usuarioInscricao = usuarioInscricao;
	}

	public Grupo getGrupoInscricao() {
		return grupoInscricao;
	}

	public void setGrupoInscricao(Grupo grupoInscricao) {
		this.grupoInscricao = grupoInscricao;
	}



	public Aprovacao getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(Aprovacao aprovacao) {
		this.aprovacao = aprovacao;
	}
	

}
