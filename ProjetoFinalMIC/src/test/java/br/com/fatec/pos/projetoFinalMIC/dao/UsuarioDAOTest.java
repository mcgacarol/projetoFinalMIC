package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.UsuarioDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.PermissaoUsuario;
import br.com.fatec.pos.projetoFinalMIC.domain.Status;
import br.com.fatec.pos.projetoFinalMIC.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	public void salvar() {
		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		usuario.setSituacao(Status.ATIVO);
		usuario.setPermissao(PermissaoUsuario.ADMINISTRADOR);
		usuario.setNomeUsuario("Administrador");
		dao.salvar(usuario);
		
		usuario = new Usuario();
		usuario.setLogin("secretaria");
		usuario.setSenha("secretaria");
		usuario.setSituacao(Status.ATIVO);
		usuario.setPermissao(PermissaoUsuario.SECRETARIA);
		usuario.setNomeUsuario("Secretaria");
		dao.salvar(usuario);
		
		usuario = new Usuario();
		usuario.setLogin("coordenador");
		usuario.setSenha("coordenador");
		usuario.setSituacao(Status.ATIVO);
		usuario.setPermissao(PermissaoUsuario.COORDENADOR);
		usuario.setNomeUsuario("Coordenador");
		dao.salvar(usuario);
		
		usuario = new Usuario();
		usuario.setLogin("professor");
		usuario.setSenha("professor");
		usuario.setSituacao(Status.ATIVO);
		usuario.setPermissao(PermissaoUsuario.PROFESSOR);
		usuario.setNomeUsuario("Professor");
		dao.salvar(usuario);
		
	}

	
	@Ignore
	public void listar() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios  = dao.listar();
		System.out.println(usuarios);
	}

	@Ignore
	public void buscar() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorCodigo(1);
		System.out.println(usuario);
	}

	@Ignore
	public void editar() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorCodigo(2);
		usuario.setSenha("teste123");
		dao.editar(usuario);
	}

	@Ignore
	public void excluir() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorCodigo(3);
		dao.excluir(usuario);
	}
}
