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
	
	@Column(name="indPermissao", nullable=false, length=20)
	private PermissaoUsuario permissao;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Funcionalidade funcionalidade;

	public PermissaoUsuario getPermissao() {
		return permissao;
	}

	public void setPermissao(PermissaoUsuario permissao) {
		this.permissao = permissao;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Navegacao other = (Navegacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Navegacao [id=" + id + ", permissao=" + permissao
				+ ", funcionalidade=" + funcionalidade + "]";
	}

	

	
}
