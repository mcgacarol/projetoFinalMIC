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

import br.com.fatec.pos.projetoFinalMIC.dao.ProfessorDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Professor;


@Path("/professor")
public class ProfessorService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		ProfessorDAO professorDAO = new ProfessorDAO();

		List<Professor> professores = professorDAO.listar();

		GenericEntity<List<Professor>> professorWrapper = new GenericEntity<List<Professor>>(
				professores) {
		};

		return Response.ok(professorWrapper).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		ProfessorDAO professorDAO = new ProfessorDAO();

		Professor professor = professorDAO.buscarPorCodigo(codigo);

		return Response.ok(professor).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Professor professor) {
		ProfessorDAO professorDAO = new ProfessorDAO();

		professorDAO.salvar(professor);

		return Response.ok(professor).build();
	}

	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo) {
		ProfessorDAO professorDAO = new ProfessorDAO();

		Professor professor = professorDAO.buscarPorCodigo(codigo);

		professorDAO.excluir(professor);

		return Response.ok(professor).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Professor professor) {
		ProfessorDAO professorDAO = new ProfessorDAO();

		professorDAO.editar(professor);

		return Response.ok(professor).build();
	}

}
