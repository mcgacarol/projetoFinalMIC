package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.AlunoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Aluno;
import br.com.fatec.pos.projetoFinalMIC.domain.AlunoEspecial;
import br.com.fatec.pos.projetoFinalMIC.domain.Status;

public class AlunoDAOTest {
	@Test
	public void salvar() {
		AlunoDAO dao = new AlunoDAO();

		Aluno aluno = new Aluno();
		aluno.setBairro("Centro");
		aluno.setCep(19970000);
		aluno.setComplemento("casa");
		aluno.setDataNascimento(new Date());
		aluno.setDddTelefone(18);
		aluno.setEspecial(AlunoEspecial.SIM);
		aluno.setFiliacao("Maria e Antonio");
		aluno.setLogradouro("Rua dos Anjos");
		aluno.setMunicipio("Palmital");
		aluno.setNome("Ana Pereira");
		aluno.setNumero(10);
		aluno.setSituacao(Status.ATIVO);
		aluno.setTelefone(997286941);
		aluno.setUf("SP");
		dao.salvar(aluno);
		
		aluno = new Aluno();
		aluno.setBairro("Vila Mariana");
		aluno.setCep(19910000);
		aluno.setComplemento("casa");
		aluno.setDataNascimento(new Date());
		aluno.setDddTelefone(14);
		aluno.setEspecial(AlunoEspecial.NAO);
		aluno.setFiliacao("Isaura e André");
		aluno.setLogradouro("Rua Antonio Mattos");
		aluno.setMunicipio("Ourinhos");
		aluno.setNome("Ricardo Alves");
		aluno.setNumero(14);
		aluno.setSituacao(Status.ATIVO);
		aluno.setTelefone(999113433);
		aluno.setUf("SP");
		dao.salvar(aluno);
		
	}

	@Test
	@Ignore
	public void listar() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> alunos  = dao.listar();
		System.out.println(alunos);
	}

	@Test
	@Ignore
	public void buscar() {
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.buscarPorCodigo(1);
		System.out.println(aluno);
	}

	@Test
	@Ignore
	public void editar() {
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.buscarPorCodigo(2);
		aluno.setNome("Ricardo Alves da Silva");
		dao.editar(aluno);
	}

	@Test
	@Ignore
	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.buscarPorCodigo(2);
		dao.excluir(aluno);
	}
}
