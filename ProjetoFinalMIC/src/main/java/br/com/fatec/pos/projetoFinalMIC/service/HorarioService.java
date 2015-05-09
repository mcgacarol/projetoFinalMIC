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

import br.com.fatec.pos.projetoFinalMIC.dao.HorarioDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Horario;


@Path("/horario")
public class HorarioService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		HorarioDAO horarioDAO = new HorarioDAO();

		List<Horario> horarios = horarioDAO.listar();

		GenericEntity<List<Horario>> horarioWrapper = new GenericEntity<List<Horario>>(
				horarios) {
		};

		return Response.ok(horarioWrapper).build();
	}

	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo) {
		HorarioDAO horarioDAO = new HorarioDAO();

		Horario horario = horarioDAO.buscarPorCodigo(codigo);

		return Response.ok(horario).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Horario horario) {
		HorarioDAO horarioDAO = new HorarioDAO();

		horarioDAO.salvar(horario);

		return Response.ok(horario).build();
	}

	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo) {
		HorarioDAO horarioDAO = new HorarioDAO();

		Horario horario = horarioDAO.buscarPorCodigo(codigo);

		horarioDAO.excluir(horario);

		return Response.ok(horario).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Horario horario) {
		HorarioDAO horarioDAO = new HorarioDAO();

		horarioDAO.editar(horario);

		return Response.ok(horario).build();
	}

}
