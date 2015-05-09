package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Matricula;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;

public class MatriculaDAO {
	
	public Matricula salvar(Matricula matricula) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(matricula);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return matricula;
	}
	
	public Matricula editar(Matricula matricula) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(matricula);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return matricula;
	}
	
	public Matricula excluir(Matricula matricula) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(matricula);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return matricula;
	}
	
	@SuppressWarnings("unchecked")
	public List<Matricula> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Matricula> matriculas = null;

		try {
			Criteria consulta = sessao.createCriteria(Matricula.class);
			consulta.addOrder(Order.asc("id"));
			
			matriculas = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return matriculas;
	}
	
	public Matricula buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Matricula matricula = null;

		try {
			Criteria consulta = sessao.createCriteria(Matricula.class);
			consulta.add(Restrictions.idEq(codigo));
			matricula = (Matricula) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return matricula;
	}
	
}
