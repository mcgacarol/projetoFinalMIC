package br.com.fatec.pos.projetoFinalMIC.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name = "navegacaoSequence", sequenceName = "navegacaoSequence", allocationSize = 1)
public class Navegacao implements Serializable{

	@Id
	@Column(name="id", nullable=false, insertable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "navegacaoSequence")
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Usuario usuario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Funcionalidade funcionalidade;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Navegacao [id=" + id + ", usuario=" + usuario.getLogin()
				+ ", funcionalidade=" + funcionalidade.getDescricao() + "] \n";
	}

	
}
