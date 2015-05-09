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
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", cargaHoraria="
				+ cargaHoraria + ", situacao=" + situacao.getDescricao() + "] \n";
	}
	
}
