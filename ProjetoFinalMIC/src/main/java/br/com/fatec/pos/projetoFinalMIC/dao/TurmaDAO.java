package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Professor;
import br.com.fatec.pos.projetoFinalMIC.domain.Turma;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;


public class TurmaDAO  {

	public Turma salvar(Turma turma) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(turma);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return turma;
	}
	
	public Turma editar(Turma turma) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(turma);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return turma;
	}
	
	public Turma excluir(Turma turma) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(turma);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return turma;
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Turma> turmas = null;

		try {
			Criteria consulta = sessao.createCriteria(Turma.class);
			consulta.addOrder(Order.asc("id"));
			
			turmas = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return turmas;
	}
	
	public Turma buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Turma turma = null;

		try {
			Criteria consulta = sessao.createCriteria(Turma.class);
			consulta.add(Restrictions.idEq(codigo));
			turma = (Turma) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return turma;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Boolean verificarDisponibilidadeProfessor(Turma turma){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Boolean professorDisponivel = null;

		try {
			Criteria consulta = sessao.createCriteria(Turma.class, "turma");
			consulta.createAlias("turma.horarioAula", "horario", Criteria.INNER_JOIN);
			consulta.createAlias("turma.professor", "professor", Criteria.INNER_JOIN);
			
			if(turma != null){
				if(turma.getHorarioAula() != null){
					consulta.add(Restrictions.eq("horario", turma.getHorarioAula()));
				}
				if(turma.getProfessor() != null){
					consulta.add(Restrictions.eq("professor", turma.getProfessor()));
				}
			}
			List<Professor> listaProfessores = (List<Professor>) consulta.list();
			
			if(listaProfessores.isEmpty()){
				professorDisponivel = true;
			}else{
				professorDisponivel = false;
			}
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return professorDisponivel;
	}
}
