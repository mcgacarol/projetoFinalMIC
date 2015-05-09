package br.com.fatec.pos.projetoFinalMIC.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fatec.pos.projetoFinalMIC.dao.CursoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Curso;

@Path("/curso")
public class CursoService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		CursoDAO cursoDAO = new CursoDAO();
		List<Curso> cursos = cursoDAO.listar();
		
		GenericEntity<List<Curso>> cursoWrapper = new GenericEntity<List<Curso>>(cursos){};
		
		return Response.ok(cursoWrapper).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo){
		CursoDAO cursoDAO = new CursoDAO();
		
		Curso curso = cursoDAO.buscarPorCodigo(codigo);
		
		return Response.ok(curso).build();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Curso curso){
		CursoDAO cursoDAO =  new CursoDAO();
		
		cursoDAO.salvar(curso);
		
		return Response.ok(curso).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo){
		CursoDAO cursoDAO = new CursoDAO();
		
		Curso curso = cursoDAO.buscarPorCodigo(codigo);
		
		cursoDAO.excluir(curso);
		
		return Response.ok(curso).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(Curso curso){
		CursoDAO cursoDAO =  new CursoDAO();
		
		cursoDAO.editar(curso);
		
		return Response.ok(curso).build();
	}
}





