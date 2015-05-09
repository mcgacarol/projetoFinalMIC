package br.com.fatec.pos.projetoFinalMIC.domain;

public enum AlunoEspecial {

	SIM(0, "Sim"),
	NAO(1, "Não");
	
	public Integer id;
	public String descricao;
	private AlunoEspecial(Integer id, String descricao) {
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
