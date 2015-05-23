package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Usuario;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;

public class UsuarioDAO {

	public Usuario salvar(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(usuario);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return usuario;
	}
	
	public Usuario editar(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(usuario);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return usuario;
	}
	
	public Usuario excluir(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(usuario);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;

		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.addOrder(Order.asc("login"));
			
			usuarios = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return usuarios;
	}
	
	public Usuario buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.add(Restrictions.idEq(codigo));
			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarioPorFiltro(String login, String situacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			Criteria criteria = sessao.createCriteria(Usuario.class);
			if(!login.equals("")){
				criteria.add(Restrictions.like("login", "%" + login + "%"));
			}
			if(!situacao.equals("")){
				criteria.add(Restrictions.eq("situacao", situacao));
			}
			listaUsuarios = (List<Usuario>) criteria.list();
		}  catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return listaUsuarios;
	}

	@SuppressWarnings("unchecked")
	public Boolean verificarDisponibilidadeLogin(String login) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Boolean disponivel = true;
		
		try {
			Criteria criteria = sessao.createCriteria(Usuario.class);
			if(!login.equals("")){
				criteria.add(Restrictions.like("login", "%" + login + "%"));
			}
			List<Usuario> listaUsuarios = (List<Usuario>) criteria.list();
			if(listaUsuarios.isEmpty()){
				disponivel = true;
			}else{
				disponivel = false;
			}
		}  catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return disponivel;
	}

	public Usuario buscarUsuario(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuarioObtido = new Usuario();
		
		try {
			Criteria criteria = sessao.createCriteria(Usuario.class);
			if(!usuario.getLogin().equals("")){
				criteria.add(Restrictions.like("login", usuario.getLogin()));
			}
			if(!usuario.getSenha().equals("")){
				criteria.add(Restrictions.eq("senha", usuario.getSenha()));
			}
			usuarioObtido = (Usuario) criteria.uniqueResult();
		}  catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return usuarioObtido;
	}
}
