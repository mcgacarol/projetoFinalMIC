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

import br.com.fatec.pos.projetoFinalMIC.dao.AvaliacaoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Avaliacao;

@Path("/avaliacao")
public class AvaliacaoService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
		List<Avaliacao> avaliacaos = avaliacaoDAO.listar();
		GenericEntity<List<Avaliacao>> avaliacaoWrapper = new GenericEntity<List<Avaliacao>>(avaliacaos){};
		return Response.ok(avaliacaoWrapper).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo){
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
		Avaliacao avaliacao = avaliacaoDAO.buscarPorCodigo(codigo);
		return Response.ok(avaliacao).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // por causa do parâmetro que é um objeto e não um tipo primitivo
	public Response salvar(Avaliacao avaliacao){
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
		avaliacaoDAO.salvar(avaliacao);
		return Response.ok(avaliacao).build(); // estou retornando a avaliacao com o ID gerado e salvo no banco
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo) {
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
		Avaliacao avaliacao = avaliacaoDAO.buscarPorCodigo(codigo);
		avaliacaoDAO.excluir(avaliacao);
		return Response.ok(avaliacao).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Avaliacao avaliacao) {
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
		avaliacaoDAO.editar(avaliacao);
		return Response.ok(avaliacao).build();
	}
}
