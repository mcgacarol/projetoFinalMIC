package br.com.fatec.pos.projetoFinalMIC.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Messages;

import br.com.fatec.pos.projetoFinalMIC.dao.CursoDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.FuncionalidadeDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.NavegacaoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Curso;
import br.com.fatec.pos.projetoFinalMIC.domain.Funcionalidade;
import br.com.fatec.pos.projetoFinalMIC.domain.Navegacao;
import br.com.fatec.pos.projetoFinalMIC.domain.Status;
import br.com.fatec.pos.projetoFinalMIC.domain.Usuario;

@ManagedBean
@ViewScoped
public class CursoBean {

	private Curso curso;
	private List<Curso> cursos;
	private Status situacaoAtivo = Status.ATIVO;
	private Status situacaoInativo = Status.INATIVO;

	public void salvar() {
		CursoDAO cursoDAO = new CursoDAO();
		if (curso.getId() == null) {
			cursoDAO.salvar(curso);
			Messages.addGlobalInfo("Curso salvo com sucesso");
		} else {
			cursoDAO.editar(curso);
			Messages.addGlobalInfo("Curso alterado com sucesso");
		}
		iniciar();
	}

	public void excluir() {
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.excluir(curso);
		Messages.addGlobalInfo("Curso excluído com sucesso");
		iniciar();
	}

	@PostConstruct
	public void iniciar() {
		HttpSession session = SessionBean.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			Usuario usuarioNaSessao = (Usuario) session.getAttribute("usuarioLogado");
			Funcionalidade funcionalidade = new FuncionalidadeDAO().obterFuncionalidadePorDescricao("Manter Cursos");
			if(usuarioNaSessao != null && funcionalidade != null){
				Navegacao navegacaoAcesso = new NavegacaoDAO().obterNavegacaoPorUsuarioFuncionalidade(usuarioNaSessao.getPermissao(), funcionalidade);
				if(navegacaoAcesso != null){
					curso = new Curso();
					curso.setSituacao(getSituacaoAtivo());
					CursoDAO cursoDAO = new CursoDAO();
					cursos = cursoDAO.listar();
				} 
			}
		}
	}

	public String acessarTela(){
		HttpSession session = SessionBean.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			Usuario usuarioNaSessao = (Usuario) session.getAttribute("usuarioLogado");
			Funcionalidade funcionalidade = new FuncionalidadeDAO().obterFuncionalidadePorDescricao("Manter Cursos");
			if(usuarioNaSessao != null && funcionalidade != null){
				Navegacao navegacaoAcesso = new NavegacaoDAO().obterNavegacaoPorUsuarioFuncionalidade(usuarioNaSessao.getPermissao(), funcionalidade);
				if(navegacaoAcesso != null){
					curso = new Curso();
					curso.setSituacao(getSituacaoAtivo());
					CursoDAO cursoDAO = new CursoDAO();
					cursos = cursoDAO.listar();
					return "curso.xhtml";
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
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Status getSituacaoAtivo() {
		return situacaoAtivo;
	}

	public void setSituacaoAtivo(Status situacaoAtivo) {
		this.situacaoAtivo = situacaoAtivo;
	}

	public Status getSituacaoInativo() {
		return situacaoInativo;
	}

	public void setSituacaoInativo(Status situacaoInativo) {
		this.situacaoInativo = situacaoInativo;
	}

}
