package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.CursoDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.HorarioDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.ProfessorDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.TurmaDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Status;
import br.com.fatec.pos.projetoFinalMIC.domain.Turma;

public class TurmaDAOTest {
	@Test
	public void salvar() {
		TurmaDAO dao = new TurmaDAO();
		
		Turma turma = new Turma();
		turma.setCurso(new CursoDAO().buscarPorCodigo(1));
		turma.setHorarioAula(new HorarioDAO().buscarPorCodigo(1));
		turma.setIdadeMaxima(4);
		turma.setIdadeMinima(3);
		turma.setProfessor(new ProfessorDAO().buscarPorCodigo(1));
		turma.setQtdAvaliacoes(2);
		turma.setSituacao(Status.ATIVO);
		dao.salvar(turma);
		
		turma = new Turma();
		turma.setCurso(new CursoDAO().buscarPorCodigo(2));
		turma.setHorarioAula(new HorarioDAO().buscarPorCodigo(2));
		turma.setIdadeMaxima(5);
		turma.setIdadeMinima(4);
		turma.setProfessor(new ProfessorDAO().buscarPorCodigo(2));
		turma.setQtdAvaliacoes(4);
		turma.setSituacao(Status.ATIVO);
		dao.salvar(turma);
		
	}

	@Test
	@Ignore
	public void listar() {
		TurmaDAO dao = new TurmaDAO();
		List<Turma> turmas  = dao.listar();
		System.out.println(turmas);
	}

	@Test
	@Ignore
	public void buscar() {
		TurmaDAO dao = new TurmaDAO();
		Turma turma = dao.buscarPorCodigo(1);
		System.out.println(turma);
	}

	@Test
	@Ignore
	public void editar() {
		TurmaDAO dao = new TurmaDAO();
		Turma turma = dao.buscarPorCodigo(1);
		turma.setIdadeMinima(2);
		dao.editar(turma);
	}

	@Test
	@Ignore
	public void excluir() {
		TurmaDAO dao = new TurmaDAO();
		Turma turma = dao.buscarPorCodigo(2);
		dao.excluir(turma);
	}
}
