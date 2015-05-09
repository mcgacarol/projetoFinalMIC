package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Professor;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;


public class ProfessorDAO {

	public Professor salvar(Professor professor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(professor);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return professor;
	}
	
	public Professor editar(Professor professor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(professor);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return professor;
	}
	
	public Professor excluir(Professor professor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(professor);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return professor;
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Professor> professors = null;

		try {
			Criteria consulta = sessao.createCriteria(Professor.class);
			consulta.addOrder(Order.asc("nome"));
			
			professors = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return professors;
	}
	
	public Professor buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Professor professor = null;

		try {
			Criteria consulta = sessao.createCriteria(Professor.class);
			consulta.add(Restrictions.idEq(codigo));
			professor = (Professor) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return professor;
	}
	
}
