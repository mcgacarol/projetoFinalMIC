package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.ProfessorDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.AtuaComEducacaoEspecial;
import br.com.fatec.pos.projetoFinalMIC.domain.Professor;
import br.com.fatec.pos.projetoFinalMIC.domain.Status;

public class ProfessorDAOTest {
	@Test
	public void salvar() {
		ProfessorDAO dao = new ProfessorDAO();

		Professor professor = new Professor();
		professor.setAtuaComEducacaoEspecial(AtuaComEducacaoEspecial.SIM);
		professor.setBairro("Centro");
		professor.setCep("19950-000");
		professor.setComplemento("casa");
		professor.setEmail("professor@email.com.br");
		professor.setLogradouro("Rua José Pereira");
		professor.setMunicipio("Ourinhos");
		professor.setNome("Marli Souza");
		professor.setNumero(20);
		professor.setSituacao(Status.ATIVO);
		professor.setTelefone("92231144");
		professor.setUf("SP");
		dao.salvar(professor);
		
		professor = new Professor();
		professor.setAtuaComEducacaoEspecial(AtuaComEducacaoEspecial.NAO);
		professor.setBairro("Centro");
		professor.setCep("19950-000");
		professor.setComplemento("casa");
		professor.setEmail("professor_teste@email.com.br");
		professor.setLogradouro("Rua Jacinto Sá");
		professor.setMunicipio("Ourinhos");
		professor.setNome("José da Silva");
		professor.setNumero(20);
		professor.setSituacao(Status.ATIVO);
		professor.setTelefone("345345454");
		professor.setUf("SP");
		dao.salvar(professor);
		
	}

	@Test
	@Ignore
	public void listar() {
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> professors  = dao.listar();
		System.out.println(professors);
	}

	@Test
	@Ignore
	public void buscar() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor professor = dao.buscarPorCodigo(1);
		System.out.println(professor);
	}

	@Test
	@Ignore
	public void editar() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor professor = dao.buscarPorCodigo(2);
		professor.setNome("José Antonio da Silva");
		dao.editar(professor);
	}

	@Test
	@Ignore
	public void excluir() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor professor = dao.buscarPorCodigo(2);
		dao.excluir(professor);
	}
}
