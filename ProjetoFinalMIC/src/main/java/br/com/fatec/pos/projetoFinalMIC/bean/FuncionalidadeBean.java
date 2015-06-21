package br.com.fatec.pos.projetoFinalMIC.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Messages;

import br.com.fatec.pos.projetoFinalMIC.dao.FuncionalidadeDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.NavegacaoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Funcionalidade;
import br.com.fatec.pos.projetoFinalMIC.domain.Navegacao;
import br.com.fatec.pos.projetoFinalMIC.domain.Usuario;

@ManagedBean
@ViewScoped
public class FuncionalidadeBean {

	private Funcionalidade funcionalidade;
	private List<Funcionalidade> funcionalidades;

	public void salvar() {
		FuncionalidadeDAO funcionalidadeDAO = new FuncionalidadeDAO();
		if (funcionalidade.getId() == null) {
			funcionalidadeDAO.salvar(funcionalidade);
			Messages.addGlobalInfo("Funcionalidade salva com sucesso");
		} else {
			funcionalidadeDAO.editar(funcionalidade);
			Messages.addGlobalInfo("Funcionalidade alterada com sucesso");
		}
		iniciar();
	}

	public void excluir() {
		FuncionalidadeDAO funcionalidadeDAO = new FuncionalidadeDAO();
		funcionalidadeDAO.excluir(funcionalidade);
		Messages.addGlobalInfo("Funcionalidade excluída com sucesso");
		iniciar();
	}

	@PostConstruct
	public void iniciar() {
		HttpSession session = SessionBean.getSession();
		if(session.getAttribute("usuarioLogado") != null){
			Usuario usuarioNaSessao = (Usuario) session.getAttribute("usuarioLogado");
			Funcionalidade funcionalidade = new FuncionalidadeDAO().obterFuncionalidadePorDescricao("Manter Funcionalidades");
			if(usuarioNaSessao != null && funcionalidade != null){
				Navegacao navegacaoAcesso = new NavegacaoDAO().obterNavegacaoPorUsuarioFuncionalidade(usuarioNaSessao.getPermissao(), funcionalidade);
				if(navegacaoAcesso != null){
					funcionalidade = new Funcionalidade();
					FuncionalidadeDAO funcionalidadeDAO = new FuncionalidadeDAO();
					funcionalidades = funcionalidadeDAO.listar();
				}
			}
		}
	}

	public String acessarTela(){
		HttpSession session = SessionBean.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			Usuario usuarioNaSessao = (Usuario) session.getAttribute("usuarioLogado");
			Funcionalidade funcionalidade = new FuncionalidadeDAO().obterFuncionalidadePorDescricao("Manter Funcionalidades");
			if(usuarioNaSessao != null && funcionalidade != null){
				Navegacao navegacaoAcesso = new NavegacaoDAO().obterNavegacaoPorUsuarioFuncionalidade(usuarioNaSessao.getPermissao(), funcionalidade);
				if(navegacaoAcesso != null){
					funcionalidade = new Funcionalidade();
					FuncionalidadeDAO funcionalidadeDAO = new FuncionalidadeDAO();
					funcionalidades = funcionalidadeDAO.listar();
					return "funcionalidade.xhtml";
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
	
	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public List<Funcionalidade> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}

