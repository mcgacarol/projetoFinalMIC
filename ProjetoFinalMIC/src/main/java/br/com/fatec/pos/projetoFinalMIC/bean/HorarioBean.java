package br.com.fatec.pos.projetoFinalMIC.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Messages;

import br.com.fatec.pos.projetoFinalMIC.dao.FuncionalidadeDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.HorarioDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.NavegacaoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Funcionalidade;
import br.com.fatec.pos.projetoFinalMIC.domain.Horario;
import br.com.fatec.pos.projetoFinalMIC.domain.Navegacao;
import br.com.fatec.pos.projetoFinalMIC.domain.Usuario;

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
		HttpSession session = SessionBean.getSession();
		if(session.getAttribute("usuarioLogado") != null){
			Usuario usuarioNaSessao = (Usuario) session.getAttribute("usuarioLogado");
			Funcionalidade funcionalidade = new FuncionalidadeDAO().obterFuncionalidadePorDescricao("Manter Horários");
			if(usuarioNaSessao != null && funcionalidade != null){
				Navegacao navegacaoAcesso = new NavegacaoDAO().obterNavegacaoPorUsuarioFuncionalidade(usuarioNaSessao.getPermissao(), funcionalidade);
				if(navegacaoAcesso != null){
					horario = new Horario();
					HorarioDAO horarioDAO = new HorarioDAO();
					horarios = horarioDAO.listar();
				}
			}
		}
	}


	public String acessarTela(){
		HttpSession session = SessionBean.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			Usuario usuarioNaSessao = (Usuario) session.getAttribute("usuarioLogado");
			Funcionalidade funcionalidade = new FuncionalidadeDAO().obterFuncionalidadePorDescricao("Manter Horários");
			if(usuarioNaSessao != null && funcionalidade != null){
				Navegacao navegacaoAcesso = new NavegacaoDAO().obterNavegacaoPorUsuarioFuncionalidade(usuarioNaSessao.getPermissao(), funcionalidade);
				if(navegacaoAcesso != null){
					horario = new Horario();
					HorarioDAO horarioDAO = new HorarioDAO();
					horarios = horarioDAO.listar();
					return "horario.xhtml";
				} else {
					Messages.addGlobalInfo("Você não possui permissão para acessar esta funcionalidade");
					return "index.html";
				}
			}else{
				return "inicio.xhtml";
			}
		}else{
			return "inicio.xhtml";
		}
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
