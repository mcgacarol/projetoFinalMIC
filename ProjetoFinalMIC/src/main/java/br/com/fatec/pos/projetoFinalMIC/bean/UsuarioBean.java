package br.com.fatec.pos.projetoFinalMIC.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.fatec.pos.projetoFinalMIC.dao.UsuarioDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	private List<Usuario> usuarios;

	public String logar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuario.getLogin() != null && usuario.getSenha() != null) {
			Usuario usuarioObtido = usuarioDAO.buscarUsuario(usuario);
			if(usuarioObtido == null){
				Messages.addGlobalInfo("Login/Senha incorretos.");
			}else{
				return "index.xhtml";
			}
		} else {
			Messages.addGlobalInfo("Login/Senha incorretos.");
		}
		iniciar();
		return "inicio.xhtml";
	}
	
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
		usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarios = usuarioDAO.listar();
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

}
