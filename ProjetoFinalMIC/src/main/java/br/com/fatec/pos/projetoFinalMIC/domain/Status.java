package br.com.fatec.pos.projetoFinalMIC.domain;

public enum Status {

	ATIVO(0, "Ativo"),
	INATIVO(1, "Inativo");
	
	public Integer id;
	public String descricao;
	private Status(Integer id, String descricao) {
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
