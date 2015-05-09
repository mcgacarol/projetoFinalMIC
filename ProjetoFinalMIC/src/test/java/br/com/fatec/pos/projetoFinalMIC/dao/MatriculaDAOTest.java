package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.AlunoDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.MatriculaDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.TurmaDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Matricula;
import br.com.fatec.pos.projetoFinalMIC.domain.SituacaoMatricula;

public class MatriculaDAOTest {
	@Test
	public void salvar() {
		MatriculaDAO dao = new MatriculaDAO();
		
		Matricula matricula = new Matricula();
		matricula.setAluno(new AlunoDAO().buscarPorCodigo(1));
		matricula.setSituacao(SituacaoMatricula.MATRICULADO);
		matricula.setTurma(new TurmaDAO().buscarPorCodigo(1));
		dao.salvar(matricula);
		
		matricula = new Matricula();
		matricula.setAluno(new AlunoDAO().buscarPorCodigo(2));
		matricula.setSituacao(SituacaoMatricula.MATRICULADO);
		matricula.setTurma(new TurmaDAO().buscarPorCodigo(2));
		dao.salvar(matricula);
		
	}

	@Test
	@Ignore
	public void listar() {
		MatriculaDAO dao = new MatriculaDAO();
		List<Matricula> matriculas  = dao.listar();
		System.out.println(matriculas);
	}

	@Test
	@Ignore
	public void buscar() {
		MatriculaDAO dao = new MatriculaDAO();
		Matricula matricula = dao.buscarPorCodigo(1);
		System.out.println(matricula);
	}

	@Test
	@Ignore
	public void editar() {
		MatriculaDAO dao = new MatriculaDAO();
		Matricula matricula = dao.buscarPorCodigo(1);
		matricula.setSituacao(SituacaoMatricula.APROVADO);
		dao.editar(matricula);
	}

	@Test
	@Ignore
	public void excluir() {
		MatriculaDAO dao = new MatriculaDAO();
		Matricula matricula = dao.buscarPorCodigo(2);
		dao.excluir(matricula);
	}
}
