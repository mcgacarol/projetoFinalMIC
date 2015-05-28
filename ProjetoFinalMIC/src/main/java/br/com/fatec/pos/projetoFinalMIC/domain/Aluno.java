package br.com.fatec.pos.projetoFinalMIC.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name = "alunoSequence", sequenceName = "alunoSequence", allocationSize = 1)
public class Aluno implements Serializable{

		@Id
		@Column(name="id", nullable=false, insertable=false)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alunoSequence")
		private Integer id;
		
		@Column(name="nome", nullable=false, length=100)
		private String nome;
		
		@Column(name="filiacao", nullable=false, length=100)
		private String filiacao;
		
		@Column(name="dataNascimento", nullable=false)
		@Temporal(TemporalType.DATE)
		private Date dataNascimento;
		
		@Column(name="indEspecial", nullable=false, length = 1)
		private AlunoEspecial especial;  
		
		@Column(name="dddTelefone", nullable=false, length=2)
		private Integer dddTelefone;
		
		@Column(name="telefone", nullable=false, length=9)
		private Integer telefone;
		
		@Column(name="logradouro", nullable=false, length=100)
		private String logradouro;
		
		@Column(name="numero", nullable=false, length=5)
		private Integer numero;
		
		@Column(name="complemento", nullable=false, length=50)
		private String complemento;
		
		@Column(name="bairro", nullable=false, length=80)
		private String bairro;
		
		@Column(name="municipio", nullable=false, length=80)
		private String municipio;
		
		@Column(name="cep", nullable=false, length=2)
		private Integer cep;
		
		@Column(name="uf", nullable=false, length=2)
		private String uf;
		
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

		public String getFiliacao() {
			return filiacao;
		}

		public void setFiliacao(String filiacao) {
			this.filiacao = filiacao;
		}

		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public AlunoEspecial getEspecial() {
			return especial;
		}

		public void setEspecial(AlunoEspecial especial) {
			this.especial = especial;
		}

		public Integer getDddTelefone() {
			return dddTelefone;
		}

		public void setDddTelefone(Integer dddTelefone) {
			this.dddTelefone = dddTelefone;
		}

		public Integer getTelefone() {
			return telefone;
		}

		public void setTelefone(Integer telefone) {
			this.telefone = telefone;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		public Integer getNumero() {
			return numero;
		}

		public void setNumero(Integer numero) {
			this.numero = numero;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getMunicipio() {
			return municipio;
		}

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}

		public Integer getCep() {
			return cep;
		}

		public void setCep(Integer cep) {
			this.cep = cep;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
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
			Aluno other = (Aluno) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Aluno [id=" + id + ", nome=" + nome + ", filiacao="
					+ filiacao + ", dataNascimento=" + dataNascimento
					+ ", especial=" + especial + ", dddTelefone=" + dddTelefone
					+ ", telefone=" + telefone + ", logradouro=" + logradouro
					+ ", numero=" + numero + ", complemento=" + complemento
					+ ", bairro=" + bairro + ", municipio=" + municipio
					+ ", cep=" + cep + ", uf=" + uf + ", situacao=" + situacao
					+ "]";
		}
		
		
		
}
