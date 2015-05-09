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
@SequenceGenerator(name = "horarioSequence", sequenceName = "horarioSequence", allocationSize = 1)
public class Horario implements Serializable {

		@Id
		@Column(name="id", nullable=false, insertable=false)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "horarioSequence")
		private Integer id;
		
		@Column(name="descricao", nullable=false, length=100)
		private String descricao;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		@Override
		public String toString() {
			return "Horario [id=" + id + ", descricao=" + descricao + "] \n";
		}
		
		

}
