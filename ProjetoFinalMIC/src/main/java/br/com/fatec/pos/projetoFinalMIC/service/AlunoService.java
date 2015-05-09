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

import br.com.fatec.pos.projetoFinalMIC.dao.AlunoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Aluno;

@Path("/aluno")
public class AlunoService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> alunos = alunoDAO.listar();
		
		GenericEntity<List<Aluno>> alunoWrapper = new GenericEntity<List<Aluno>>(alunos){};
		
		return Response.ok(alunoWrapper).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo){
		AlunoDAO alunoDAO = new AlunoDAO();
		
		Aluno aluno = alunoDAO.buscarPorCodigo(codigo);
		
		return Response.ok(aluno).build();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Aluno aluno){
		AlunoDAO alunoDAO =  new AlunoDAO();
		
		alunoDAO.salvar(aluno);
		
		return Response.ok(aluno).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo){
		AlunoDAO alunoDAO = new AlunoDAO();
		
		Aluno aluno = alunoDAO.buscarPorCodigo(codigo);
		
		alunoDAO.excluir(aluno);
		
		return Response.ok(aluno).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(Aluno aluno){
		AlunoDAO alunoDAO =  new AlunoDAO();
		
		alunoDAO.editar(aluno);
		
		return Response.ok(aluno).build();
	}
}

