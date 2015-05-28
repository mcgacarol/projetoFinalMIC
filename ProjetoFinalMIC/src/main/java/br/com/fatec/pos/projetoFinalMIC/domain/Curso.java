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
@SequenceGenerator(name = "cursoSequence", sequenceName = "cursoSequence", allocationSize = 1)
public class Curso implements Serializable{

	@Id
	@Column(name="id", nullable=false, insertable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cursoSequence")
	private Integer id;
	
	@Column(name="nome", nullable=false, length=100)
	private String nome;
	
	@Column(name="cargaHoraria", nullable=false)
	private Integer cargaHoraria;
	
	@Column(name="indSituacao", nullable=false)
	private Status situacao; 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Status getSituacao() {
		return situacao;
	}
	public void setSituacao(Status situacao) {
		this.situacao = situacao;
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", cargaHoraria="
				+ cargaHoraria + ", situacao=" + situacao + "]";
	}
	
	
}
