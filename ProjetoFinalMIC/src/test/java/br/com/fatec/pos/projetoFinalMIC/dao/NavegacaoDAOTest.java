package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fatec.pos.projetoFinalMIC.dao.FuncionalidadeDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.NavegacaoDAO;
import br.com.fatec.pos.projetoFinalMIC.dao.UsuarioDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Navegacao;

public class NavegacaoDAOTest {
	@Test
	public void salvar() {
		NavegacaoDAO dao = new NavegacaoDAO();
		
		Navegacao navegacao = new Navegacao();
		navegacao.setFuncionalidade(new FuncionalidadeDAO().buscarPorCodigo(1));
		navegacao.setUsuario(new UsuarioDAO().buscarPorCodigo(1));
		dao.salvar(navegacao);
		
		navegacao = new Navegacao();
		navegacao.setFuncionalidade(new FuncionalidadeDAO().buscarPorCodigo(2));
		navegacao.setUsuario(new UsuarioDAO().buscarPorCodigo(1));
		dao.salvar(navegacao);
		
		navegacao = new Navegacao();
		navegacao.setFuncionalidade(new FuncionalidadeDAO().buscarPorCodigo(3));
		navegacao.setUsuario(new UsuarioDAO().buscarPorCodigo(1));
		dao.salvar(navegacao);
		
		navegacao = new Navegacao();
		navegacao.setFuncionalidade(new FuncionalidadeDAO().buscarPorCodigo(1));
		navegacao.setUsuario(new UsuarioDAO().buscarPorCodigo(2));
		dao.salvar(navegacao);
		
		
	}

	@Test
	@Ignore
	public void listar() {
		NavegacaoDAO dao = new NavegacaoDAO();
		List<Navegacao> navegacaos  = dao.listar();
		System.out.println(navegacaos);
	}

	@Test
	@Ignore
	public void buscar() {
		NavegacaoDAO dao = new NavegacaoDAO();
		Navegacao navegacao = dao.buscarPorCodigo(1);
		System.out.println(navegacao);
	}

	@Test
	@Ignore
	public void editar() {
		NavegacaoDAO dao = new NavegacaoDAO();
		Navegacao navegacao = dao.buscarPorCodigo(4);
		navegacao.setFuncionalidade(new FuncionalidadeDAO().buscarPorCodigo(2));
		dao.editar(navegacao);
	}

	@Test
	@Ignore
	public void excluir() {
		NavegacaoDAO dao = new NavegacaoDAO();
		Navegacao navegacao = dao.buscarPorCodigo(3);
		dao.excluir(navegacao);
	}
}
