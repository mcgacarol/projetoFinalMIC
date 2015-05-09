package br.com.fatec.pos.projetoFinalMIC.domain;

public enum StatusAvaliacao {

	SUFICIENTE(0, "Suficiente"),
	INSUFICIENTE(1, "Insuficiente");
	
	public Integer id;
	public String descricao;
	private StatusAvaliacao(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
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
	
}
