package br.com.fatec.pos.projetoFinalMIC.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.fatec.pos.projetoFinalMIC.dao.HorarioDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Horario;

@ManagedBean
@ViewScoped
public class HorarioBean {

	private Horario horario;
	private List<Horario> horarios;

	public void salvar() {
		HorarioDAO horarioDAO = new HorarioDAO();
		if (horario.getId() == null) {
			horarioDAO.salvar(horario);
			Messages.addGlobalInfo("Horario salvo com sucesso");
		} else {
			horarioDAO.editar(horario);
			Messages.addGlobalInfo("Horario alterado com sucesso");
		}
		iniciar();
	}

	public void excluir() {
		HorarioDAO horarioDAO = new HorarioDAO();
		horarioDAO.excluir(horario);
		Messages.addGlobalInfo("Horario excluído com sucesso");
		iniciar();
	}

	@PostConstruct
	public void iniciar() {
		horario = new Horario();
		HorarioDAO horarioDAO = new HorarioDAO();
		horarios = horarioDAO.listar();
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

}
