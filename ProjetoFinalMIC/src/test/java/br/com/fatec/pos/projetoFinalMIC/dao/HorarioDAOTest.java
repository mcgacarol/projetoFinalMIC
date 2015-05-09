package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.HorarioDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Horario;

public class HorarioDAOTest {

	@Test
	public void salvar() {
		HorarioDAO dao = new HorarioDAO();

		Horario horario = new Horario();
		horario.setDescricao("MATUTINO - Das 08:00 as 11:00 horas");
		dao.salvar(horario);
		
		horario = new Horario();
		horario.setDescricao("VESPERTINO - Das 12:00 as 17:00 horas");
		dao.salvar(horario);
		
		horario = new Horario();
		horario.setDescricao("INTEGRAL - Das 08:00 as 17:00 horas");
		dao.salvar(horario);
	}

	@Test
	@Ignore
	public void listar() {
		HorarioDAO dao = new HorarioDAO();
		List<Horario> horarios  = dao.listar();
		System.out.println(horarios);
	}

	@Test
	@Ignore
	public void buscar() {
		HorarioDAO dao = new HorarioDAO();
		Horario horario = dao.buscarPorCodigo(1);
		System.out.println(horario);
	}

	@Test
	@Ignore
	public void editar() {
		HorarioDAO dao = new HorarioDAO();
		Horario horario = dao.buscarPorCodigo(2);
		horario.setDescricao("VESP. - Das 12:00 as 17:00 horas");
		dao.editar(horario);
	}

	@Test
	@Ignore
	public void excluir() {
		HorarioDAO dao = new HorarioDAO();
		Horario horario = dao.buscarPorCodigo(3);
		dao.excluir(horario);
	}
	
}
