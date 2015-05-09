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
	
	@Column(name="uf", nullable=false, length=2)
	private String uf;
	
	@Column(name="cep", nullable=false, length=2)
	private Integer cep;
	
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
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
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", dddTelefone=" + dddTelefone + ", telefone=" + telefone
				+ ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro
				+ ", municipio=" + municipio + ", uf=" + uf + ", cep=" + cep
				+ ", situacao=" + situacao.getDescricao() + ", atuaComEducacaoEspecial="
				+ atuaComEducacaoEspecial.getDescricao() + "] \n";
	}
	
	
}
