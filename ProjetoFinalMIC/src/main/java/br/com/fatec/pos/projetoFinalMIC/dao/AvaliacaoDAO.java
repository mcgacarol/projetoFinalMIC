package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Avaliacao;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;


public class AvaliacaoDAO  {

	public Avaliacao salvar(Avaliacao avaliacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(avaliacao);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return avaliacao;
	}
	
	public Avaliacao editar(Avaliacao avaliacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(avaliacao);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return avaliacao;
	}
	
	public Avaliacao excluir(Avaliacao avaliacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(avaliacao);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return avaliacao;
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacao> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Avaliacao> avaliacaos = null;

		try {
			Criteria consulta = sessao.createCriteria(Avaliacao.class);
			consulta.addOrder(Order.asc("id"));
			
			avaliacaos = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return avaliacaos;
	}
	
	public Avaliacao buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Avaliacao avaliacao = null;

		try {
			Criteria consulta = sessao.createCriteria(Avaliacao.class);
			consulta.add(Restrictions.idEq(codigo));
			avaliacao = (Avaliacao) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return avaliacao;
	}
	
}

