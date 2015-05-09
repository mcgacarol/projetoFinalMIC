package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.AvaliacaoDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.MatriculaDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.ProfessorDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Avaliacao;
import br.com.fatec.pos.projetoFinalMIC.domain.StatusAvaliacao;

public class AvaliacaoDAOTest {
	@Test
	public void salvar() {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setDescricao("Aluno muito esforçado e dedicado");
		avaliacao.setMatricula(new MatriculaDAO().buscarPorCodigo(1));
		avaliacao.setProfessor(new ProfessorDAO().buscarPorCodigo(1));
		avaliacao.setStatus(StatusAvaliacao.SUFICIENTE);
		dao.salvar(avaliacao);
		
		avaliacao = new Avaliacao();
		avaliacao.setDescricao("Aluno com dificuldades de aprendizagem");
		avaliacao.setMatricula(new MatriculaDAO().buscarPorCodigo(2));
		avaliacao.setProfessor(new ProfessorDAO().buscarPorCodigo(2));
		avaliacao.setStatus(StatusAvaliacao.INSUFICIENTE);
		dao.salvar(avaliacao);
		
	}

	@Test
	@Ignore
	public void listar() {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		List<Avaliacao> avaliacaos  = dao.listar();
		System.out.println(avaliacaos);
	}

	@Test
	@Ignore
	public void buscar() {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao avaliacao = dao.buscarPorCodigo(1);
		System.out.println(avaliacao);
	}

	@Test
	@Ignore
	public void editar() {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao avaliacao = dao.buscarPorCodigo(1);
		avaliacao.setDescricao("Aluno esforçado e pronto para próxima turma");
		dao.editar(avaliacao);
	}

	@Test
	@Ignore
	public void excluir() {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao avaliacao = dao.buscarPorCodigo(2);
		dao.excluir(avaliacao);
	}
}
