package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.CursoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Curso;
import br.com.fatec.pos.projetoFinalMIC.domain.Status;

public class CursoDAOTest {
	@Test
	public void salvar() {
		CursoDAO dao = new CursoDAO();

		Curso curso = new Curso();
		curso.setNome("Pré 1");
		curso.setCargaHoraria(300);
		curso.setSituacao(Status.ATIVO);
		dao.salvar(curso);
		
		curso = new Curso();
		curso.setNome("Pré 2");
		curso.setCargaHoraria(300);
		curso.setSituacao(Status.ATIVO);
		dao.salvar(curso);
		
		curso = new Curso();
		curso.setNome("Jardim 1");
		curso.setCargaHoraria(300);
		curso.setSituacao(Status.ATIVO);
		dao.salvar(curso);
		
	}

	@Test
	@Ignore
	public void listar() {
		CursoDAO dao = new CursoDAO();
		List<Curso> cursos  = dao.listar();
		System.out.println(cursos);
	}

	@Test
	@Ignore
	public void buscar() {
		CursoDAO dao = new CursoDAO();
		Curso curso = dao.buscarPorCodigo(1);
		System.out.println(curso);
	}

	@Test
	@Ignore
	public void editar() {
		CursoDAO dao = new CursoDAO();
		Curso curso = dao.buscarPorCodigo(2);
		curso.setNome("Pré II");
		dao.editar(curso);
	}

	@Test
	@Ignore
	public void excluir() {
		CursoDAO dao = new CursoDAO();
		Curso curso = dao.buscarPorCodigo(3);
		dao.excluir(curso);
	}
}
