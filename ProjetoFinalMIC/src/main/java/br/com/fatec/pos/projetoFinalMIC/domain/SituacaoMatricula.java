package br.com.fatec.pos.projetoFinalMIC.domain;

public enum SituacaoMatricula {
	
	MATRICULADO(0, "Matriculado"),
	CANCELADO(1, "Cancelado"),
	APROVADO(2, "Aprovado"),
	REPROVADO(3, "Reprovado"),
	TRANCADO(4,"Trancada");
	
	public Integer id;
	public String descricao;
	private SituacaoMatricula(Integer id, String descricao) {
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
