package br.com.fatec.pos.projetoFinalMIC.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Messages;

import br.com.fatec.pos.projetoFinalMIC.dao.FuncionalidadeDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.NavegacaoDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.UsuarioDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Funcionalidade;
import br.com.fatec.pos.projetoFinalMIC.domain.Navegacao;
import br.com.fatec.pos.projetoFinalMIC.domain.PermissaoUsuario;
import br.com.fatec.pos.projetoFinalMIC.domain.Status;
import br.com.fatec.pos.projetoFinalMIC.domain.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	private List<Usuario> usuarios;
	private Status situacaoAtivo = Status.ATIVO;
	private Status situacaoInativo = Status.INATIVO;
	private PermissaoUsuario permissaoAdministrador = PermissaoUsuario.ADMINISTRADOR;
	private PermissaoUsuario permissaoCoordenador = PermissaoUsuario.COORDENADOR;
	private PermissaoUsuario permissaoProfessor = PermissaoUsuario.PROFESSOR;
	private PermissaoUsuario permissaoSecretaria = PermissaoUsuario.SECRETARIA;
	
	public void salvar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuario.getId() == null) {
			usuarioDAO.salvar(usuario);
			Messages.addGlobalInfo("Usuario salvo com sucesso");
		} else {
			usuarioDAO.editar(usuario);
			Messages.addGlobalInfo("Usuario alterado com sucesso");
		}
		iniciar();
	}

	public void excluir() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);
		Messages.addGlobalInfo("Usuario excluído com sucesso");
		iniciar();
	}

	@PostConstruct
	public void iniciar() {
		HttpSession session = SessionBean.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			Usuario usuarioNaSessao = (Usuario) session.getAttribute("usuarioLogado");
			Funcionalidade funcionalidade = new FuncionalidadeDAO().obterFuncionalidadePorDescricao("Manter Usuários");
			if(usuarioNaSessao != null && funcionalidade != null){
				Navegacao navegacaoAcesso = new NavegacaoDAO().obterNavegacaoPorUsuarioFuncionalidade(usuarioNaSessao.getPermissao(), funcionalidade);
				if(navegacaoAcesso != null){
					usuario = new Usuario();
					usuario.setSituacao(getSituacaoAtivo());
					usuario.setPermissao(getPermissaoSecretaria());
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					usuarios = usuarioDAO.listar();
				}
			}
		}
	}
	
	public String acessarTela(){
		HttpSession session = SessionBean.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			Usuario usuarioNaSessao = (Usuario) session.getAttribute("usuarioLogado");
			Funcionalidade funcionalidade = new FuncionalidadeDAO().obterFuncionalidadePorDescricao("Manter Usuários");
			if(usuarioNaSessao != null && funcionalidade != null){
				Navegacao navegacaoAcesso = new NavegacaoDAO().obterNavegacaoPorUsuarioFuncionalidade(usuarioNaSessao.getPermissao(), funcionalidade);
				if(navegacaoAcesso != null){
					usuario = new Usuario();
					usuario.setSituacao(getSituacaoAtivo());
					usuario.setPermissao(getPermissaoSecretaria());
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					usuarios = usuarioDAO.listar();
					return "usuario.xhtml";
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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

	public PermissaoUsuario getPermissaoAdministrador() {
		return permissaoAdministrador;
	}

	public void setPermissaoAdministrador(PermissaoUsuario permissaoAdministrador) {
		this.permissaoAdministrador = permissaoAdministrador;
	}

	public PermissaoUsuario getPermissaoCoordenador() {
		return permissaoCoordenador;
	}

	public void setPermissaoCoordenador(PermissaoUsuario permissaoCoordenador) {
		this.permissaoCoordenador = permissaoCoordenador;
	}

	public PermissaoUsuario getPermissaoProfessor() {
		return permissaoProfessor;
	}

	public void setPermissaoProfessor(PermissaoUsuario permissaoProfessor) {
		this.permissaoProfessor = permissaoProfessor;
	}

	public PermissaoUsuario getPermissaoSecretaria() {
		return permissaoSecretaria;
	}

	public void setPermissaoSecretaria(PermissaoUsuario permissaoSecretaria) {
		this.permissaoSecretaria = permissaoSecretaria;
	}
	
}
