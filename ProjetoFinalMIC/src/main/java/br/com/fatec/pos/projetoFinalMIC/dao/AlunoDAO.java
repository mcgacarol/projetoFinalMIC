package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Aluno;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;


public class AlunoDAO {

	public Aluno salvar(Aluno aluno) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(aluno);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return aluno;
	}
	
	public Aluno editar(Aluno aluno) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(aluno);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return aluno;
	}
	
	public Aluno excluir(Aluno aluno) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(aluno);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return aluno;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Aluno> alunos = null;

		try {
			Criteria consulta = sessao.createCriteria(Aluno.class);
			consulta.addOrder(Order.asc("nome"));
			
			alunos = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return alunos;
	}
	
	public Aluno buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Aluno aluno = null;

		try {
			Criteria consulta = sessao.createCriteria(Aluno.class);
			consulta.add(Restrictions.idEq(codigo));
			aluno = (Aluno) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return aluno;
	}

}
