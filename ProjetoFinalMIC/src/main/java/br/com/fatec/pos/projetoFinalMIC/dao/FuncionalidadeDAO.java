
package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Funcionalidade;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;

public class FuncionalidadeDAO  {

	public Funcionalidade salvar(Funcionalidade funcionalidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(funcionalidade);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return funcionalidade;
	}
	
	public Funcionalidade editar(Funcionalidade funcionalidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(funcionalidade);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return funcionalidade;
	}
	
	public Funcionalidade excluir(Funcionalidade funcionalidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(funcionalidade);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return funcionalidade;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionalidade> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Funcionalidade> funcionalidades = null;

		try {
			Criteria consulta = sessao.createCriteria(Funcionalidade.class);
			consulta.addOrder(Order.asc("descricao"));
			
			funcionalidades = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return funcionalidades;
	}
	
	public Funcionalidade buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionalidade funcionalidade = null;

		try {
			Criteria consulta = sessao.createCriteria(Funcionalidade.class);
			consulta.add(Restrictions.idEq(codigo));
			funcionalidade = (Funcionalidade) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return funcionalidade;
	}
	
	public Funcionalidade obterFuncionalidadePorDescricao(String descricao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionalidade funcionalidade= new Funcionalidade();
		try {
			Criteria criteria = sessao.createCriteria(Funcionalidade.class);
			if(!descricao.equals("")){
				criteria.add(Restrictions.like("descricao", "%" + descricao + "%"));
			}
			funcionalidade = (Funcionalidade) criteria.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return funcionalidade;
	}

}
