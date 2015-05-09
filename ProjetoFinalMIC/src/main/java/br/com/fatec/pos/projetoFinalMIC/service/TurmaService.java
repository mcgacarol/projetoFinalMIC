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

import br.com.fatec.pos.projetoFinalMIC.dao.TurmaDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Turma;

@Path("/turma")
public class TurmaService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> turmas = turmaDAO.listar();
		
		GenericEntity<List<Turma>> turmaWrapper = new GenericEntity<List<Turma>>(turmas){};
		
		return Response.ok(turmaWrapper).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo){
		TurmaDAO turmaDAO = new TurmaDAO();
		
		Turma turma = turmaDAO.buscarPorCodigo(codigo);
		
		return Response.ok(turma).build();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Turma turma){
		TurmaDAO turmaDAO = new TurmaDAO();
		
		turmaDAO.salvar(turma);
		
		return Response.ok(turma).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo){
		TurmaDAO turmaDAO = new TurmaDAO();
		
		Turma turma = turmaDAO.buscarPorCodigo(codigo);
		
		turmaDAO.excluir(turma);
		
		return Response.ok(turma).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(Turma turma){
		TurmaDAO turmaDAO =  new TurmaDAO();
		
		turmaDAO.editar(turma);
		
		return Response.ok(turma).build();
	}
}











