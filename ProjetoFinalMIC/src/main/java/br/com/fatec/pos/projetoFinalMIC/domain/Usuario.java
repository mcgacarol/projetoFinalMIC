package br.com.fatec.pos.projetoFinalMIC.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name = "usuarioSequence", sequenceName = "usuarioSequence", allocationSize = 1)
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSequence")
	@Column(name="id", nullable=false, insertable=false)
	private Integer id;
	
	@Column(name="login", nullable=false, length=100)
	private String login;
	
	@Column(name="senha", nullable=false, length=100)
	private String senha;
	
	@Column(name="indSituacao", nullable=false)
	private Status situacao; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Status getSituacao() {
		return situacao;
	}

	public void setSituacao(Status situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha
				+ ", situacao=" + situacao.getDescricao() + "] \n";
	}
	
	
}
