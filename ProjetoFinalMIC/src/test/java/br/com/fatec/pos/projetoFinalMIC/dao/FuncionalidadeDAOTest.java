package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.FuncionalidadeDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Funcionalidade;

public class FuncionalidadeDAOTest {
	@Test
	public void salvar() {
		FuncionalidadeDAO dao = new FuncionalidadeDAO();

		Funcionalidade funcionalidade = new Funcionalidade();
		funcionalidade.setDescricao("Manter Aluno");
		dao.salvar(funcionalidade);
		
		funcionalidade = new Funcionalidade();
		funcionalidade.setDescricao("Manter Turma");
		dao.salvar(funcionalidade);
		
		funcionalidade = new Funcionalidade();
		funcionalidade.setDescricao("Manter Curso");
		dao.salvar(funcionalidade);
		
	}

	@Test
	@Ignore
	public void listar() {
		FuncionalidadeDAO dao = new FuncionalidadeDAO();
		List<Funcionalidade> funcionalidades  = dao.listar();
		System.out.println(funcionalidades);
	}

	@Test
	@Ignore
	public void buscar() {
		FuncionalidadeDAO dao = new FuncionalidadeDAO();
		Funcionalidade funcionalidade = dao.buscarPorCodigo(1);
		System.out.println(funcionalidade);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionalidadeDAO dao = new FuncionalidadeDAO();
		Funcionalidade funcionalidade = dao.buscarPorCodigo(2);
		funcionalidade.setDescricao("Manter Turmas");
		dao.editar(funcionalidade);
	}

	@Test
	@Ignore
	public void excluir() {
		FuncionalidadeDAO dao = new FuncionalidadeDAO();
		Funcionalidade funcionalidade = dao.buscarPorCodigo(3);
		dao.excluir(funcionalidade);
	}
}
