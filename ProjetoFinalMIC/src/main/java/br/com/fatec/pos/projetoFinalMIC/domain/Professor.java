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
@SequenceGenerator(name = "professorSequence", sequenceName = "professorSequence", allocationSize = 1)
public class Professor implements Serializable{

	@Id
	@Column(name="id", nullable=false, insertable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professorSequence")
	private Integer id;
	
	@Column(name="nome", nullable=false, length=100)
	private String nome;
	
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Column(name="telefone", nullable=false, length=14)
	private String telefone;
	
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
	
	@Column(name="uf", nullable=false, length=2)
	private String uf;
	
	@Column(name="cep", nullable=false, length=10)
	private String cep;
	
	@Column(name="indSituacao", nullable=false)
	private Status situacao; 
	
	@Column(name="indAtuaComEducacaoEspecial", nullable=false)
	private AtuaComEducacaoEspecial atuaComEducacaoEspecial;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Status getSituacao() {
		return situacao;
	}
	public void setSituacao(Status situacao) {
		this.situacao = situacao;
	}
	public AtuaComEducacaoEspecial getAtuaComEducacaoEspecial() {
		return atuaComEducacaoEspecial;
	}
	public void setAtuaComEducacaoEspecial(AtuaComEducacaoEspecial atuaComEducacaoEspecial) {
		this.atuaComEducacaoEspecial = atuaComEducacaoEspecial;
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
		Professor other = (Professor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", telefone=" + telefone
				+ ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro
				+ ", municipio=" + municipio + ", uf=" + uf + ", cep=" + cep
				+ ", situacao=" + situacao + ", atuaComEducacaoEspecial="
				+ atuaComEducacaoEspecial + "]";
	}
	
	
}
