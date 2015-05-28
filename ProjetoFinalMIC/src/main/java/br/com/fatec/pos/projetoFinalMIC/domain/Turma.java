package br.com.fatec.pos.projetoFinalMIC.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name = "turmaSequence", sequenceName = "turmaSequence", allocationSize = 1)
public class Turma implements Serializable{
	
	@Id
	@Column(name="id", nullable=false, insertable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turmaSequence")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Curso curso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Professor professor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Horario horarioAula;
	
	@Column(name="indSituacao", nullable=false)
	private Status situacao;
	
	@Column(name="idadeMinima", nullable=false, length=5)
	private Integer idadeMinima;
	
	@Column(name="idadeMaxima", nullable=false, length=5)
	private Integer idadeMaxima;
	
	@Column(name="qtdAvaliacoes", nullable=false, length=5)
	private Integer qtdAvaliacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Horario getHorarioAula() {
		return horarioAula;
	}

	public void setHorarioAula(Horario horarioAula) {
		this.horarioAula = horarioAula;
	}

	public Status getSituacao() {
		return situacao;
	}

	public void setSituacao(Status situacao) {
		this.situacao = situacao;
	}

	public Integer getIdadeMinima() {
		return idadeMinima;
	}

	public void setIdadeMinima(Integer idadeMinima) {
		this.idadeMinima = idadeMinima;
	}

	public Integer getIdadeMaxima() {
		return idadeMaxima;
	}

	public void setIdadeMaxima(Integer idadeMaxima) {
		this.idadeMaxima = idadeMaxima;
	}

	public Integer getQtdAvaliacoes() {
		return qtdAvaliacoes;
	}

	public void setQtdAvaliacoes(Integer qtdAvaliacoes) {
		this.qtdAvaliacoes = qtdAvaliacoes;
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", curso=" + curso + ", professor="
				+ professor + ", horarioAula=" + horarioAula + ", situacao="
				+ situacao + ", idadeMinima=" + idadeMinima + ", idadeMaxima="
				+ idadeMaxima + ", qtdAvaliacoes=" + qtdAvaliacoes + "]";
	}

}
