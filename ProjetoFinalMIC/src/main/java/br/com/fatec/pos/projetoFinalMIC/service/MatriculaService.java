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

import br.com.fatec.pos.projetoFinalMIC.dao.MatriculaDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Matricula;


@Path("/matricula")
public class MatriculaService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		List<Matricula> matriculas = matriculaDAO.listar();
		GenericEntity<List<Matricula>> matriculaWrapper = new GenericEntity<List<Matricula>>(matriculas){};
		return Response.ok(matriculaWrapper).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo){
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		Matricula matricula = matriculaDAO.buscarPorCodigo(codigo);
		return Response.ok(matricula).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // por causa do parâmetro que é um objeto e não um tipo primitivo
	public Response salvar(Matricula matricula){
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		matriculaDAO.salvar(matricula);
		return Response.ok(matricula).build(); // estou retornando a matricula com o ID gerado e salvo no banco
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo) {
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		Matricula matricula = matriculaDAO.buscarPorCodigo(codigo);
		matriculaDAO.excluir(matricula);
		return Response.ok(matricula).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Matricula matricula) {
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		matriculaDAO.editar(matricula);
		return Response.ok(matricula).build();
	}
}
