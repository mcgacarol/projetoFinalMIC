package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Funcionalidade;
import br.com.fatec.pos.projetoFinalMIC.domain.Navegacao;
import br.com.fatec.pos.projetoFinalMIC.domain.PermissaoUsuario;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;

public class NavegacaoDAO {

	public Navegacao salvar(Navegacao navegacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(navegacao);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return navegacao;
	}
	
	public Navegacao editar(Navegacao navegacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(navegacao);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return navegacao;
	}
	
	public Navegacao excluir(Navegacao navegacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(navegacao);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return navegacao;
	}
	
	@SuppressWarnings("unchecked")
	public List<Navegacao> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Navegacao> navegacaos = null;

		try {
			Criteria consulta = sessao.createCriteria(Navegacao.class);
			consulta.addOrder(Order.asc("id"));
			
			navegacaos = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return navegacaos;
	}
	
	public Navegacao buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Navegacao navegacao = null;

		try {
			Criteria consulta = sessao.createCriteria(Navegacao.class);
			consulta.add(Restrictions.idEq(codigo));
			navegacao = (Navegacao) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return navegacao;
	}
	
	@SuppressWarnings("unchecked")
	public List<Navegacao> listarNavegacoesPorNavegacao(Navegacao navegacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Navegacao> listarNavegacoes = new ArrayList<Navegacao>();
		
		try {
			Criteria criteria = sessao.createCriteria(Navegacao.class);
			if(navegacao != null){
				criteria.add(Restrictions.eq("navegacao", navegacao));
			}
			listarNavegacoes = (List<Navegacao>) criteria.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return listarNavegacoes;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Navegacao> listarNavegacoesPorFiltro(String funcionalidade, String navegacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Navegacao> listarNavegacoes = new ArrayList<Navegacao>();
		
		try {
			Criteria criteria = sessao.createCriteria(Navegacao.class, "navegacao");
			criteria.createAlias("navegacao.funcionalidade", "funcionalidade", Criteria.INNER_JOIN);
			criteria.createAlias("navegacao.navegacao", "navegacao", Criteria.INNER_JOIN);
			
			if(funcionalidade != null){
				criteria.add(Restrictions.like("funcionalidade.descricao", "%" + funcionalidade + "%"));
			}
			if(navegacao != null){
				criteria.add(Restrictions.like("navegacao.login", "%" + navegacao + "%"));
			}
			listarNavegacoes = (List<Navegacao>) criteria.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return listarNavegacoes;
	}

	@SuppressWarnings("unchecked")
	public Boolean validarNavegacao(Funcionalidade funcionalidade, Navegacao navegacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Boolean navegacaoValida = null;
		try {
			Criteria criteria = sessao.createCriteria(Navegacao.class, "navegacao");
			if(funcionalidade != null){
				criteria.add(Restrictions.like("navegacao.funcionalidade",funcionalidade));
			}
			if(navegacao != null){
				criteria.add(Restrictions.like("navegacao.navegacao", navegacao));
			}
			List<Navegacao> listarNavegacoes = (List<Navegacao>) criteria.list();
			if(listarNavegacoes.isEmpty()){
				navegacaoValida =  false;
			}else{
				navegacaoValida = true;
			}
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return navegacaoValida;
	}

	public Navegacao obterNavegacaoPorUsuarioFuncionalidade(PermissaoUsuario permissaoUsuario,
			Funcionalidade funcionalidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Navegacao navegacao = new Navegacao();
		
		try {
			Criteria criteria = sessao.createCriteria(Navegacao.class, "navegacao");
			
			if(permissaoUsuario != null){
				criteria.add(Restrictions.eq("navegacao.permissao", permissaoUsuario));
			}
			if(funcionalidade != null){
				criteria.add(Restrictions.eq("navegacao.funcionalidade", funcionalidade));
			}
			navegacao = (Navegacao) criteria.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return navegacao;
	}
}
