
package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Horario;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;

public class HorarioDAO  {

	public Horario salvar(Horario horario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(horario);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return horario;
	}
	
	public Horario editar(Horario horario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(horario);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return horario;
	}
	
	public Horario excluir(Horario horario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(horario);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return horario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Horario> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Horario> horarios = null;

		try {
			Criteria consulta = sessao.createCriteria(Horario.class);
			consulta.addOrder(Order.asc("id"));
			
			horarios = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return horarios;
	}
	
	public Horario buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Horario horario = null;

		try {
			Criteria consulta = sessao.createCriteria(Horario.class);
			consulta.add(Restrictions.idEq(codigo));
			horario = (Horario) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return horario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Horario> listarHorariosPorDescricao(String descricao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Horario> listaHorarios= new ArrayList<Horario>();
		try {
			Criteria criteria = sessao.createCriteria(Horario.class);
			if(!descricao.equals("")){
				criteria.add(Restrictions.like("descricao", "%" + descricao + "%"));
			}
			listaHorarios = (List<Horario>) criteria.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return listaHorarios;
	}

}
