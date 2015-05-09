package br.com.fatec.pos.projetoFinalMIC.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fatec.pos.projetoFinalMIC.domain.Curso;
import br.com.fatec.pos.projetoFinalMIC.util.HibernateUtil;

public class CursoDAO {
	
	public Curso salvar(Curso curso) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(curso);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return curso;
	}
	
	public Curso editar(Curso curso) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(curso);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return curso;
	}
	
	public Curso excluir(Curso curso) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(curso);
			transacao.commit();
		} catch (RuntimeException runtimeException) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return curso;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Curso> cursos = null;

		try {
			Criteria consulta = sessao.createCriteria(Curso.class);
			consulta.addOrder(Order.asc("nome"));
			
			cursos = consulta.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return cursos;
	}
	
	public Curso buscarPorCodigo(Integer codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Curso curso = null;

		try {
			Criteria consulta = sessao.createCriteria(Curso.class);
			consulta.add(Restrictions.idEq(codigo));
			curso = (Curso) consulta.uniqueResult();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		
		return curso;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> listarCursoPorFiltro(String nome, String situacao) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Curso> listaCursos = new ArrayList<Curso>();
		try {
			Criteria criteria = sessao.createCriteria(Curso.class);
			if(!nome.equals("")){
				criteria.add(Restrictions.like("nome", "%" + nome + "%"));
			}
			if(!situacao.equals("")){
				criteria.add(Restrictions.eq("situacao", situacao));
			}
			listaCursos = (List<Curso>) criteria.list();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} finally {
			sessao.close();
		}
		return listaCursos;
	}

}
