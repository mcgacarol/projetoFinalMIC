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

import br.com.fatec.pos.projetoFinalMIC.dao.NavegacaoDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Navegacao;

@Path("/navegacao")
public class NavegacaoService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		NavegacaoDAO navegacaoDAO = new NavegacaoDAO();
		List<Navegacao> navegacaos = navegacaoDAO.listar();
		GenericEntity<List<Navegacao>> navegacaoWrapper = new GenericEntity<List<Navegacao>>(navegacaos){};
		return Response.ok(navegacaoWrapper).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo){
		NavegacaoDAO navegacaoDAO = new NavegacaoDAO();
		Navegacao navegacao = navegacaoDAO.buscarPorCodigo(codigo);
		return Response.ok(navegacao).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // por causa do parâmetro que é um objeto e não um tipo primitivo
	public Response salvar(Navegacao navegacao){
		NavegacaoDAO navegacaoDAO = new NavegacaoDAO();
		navegacaoDAO.salvar(navegacao);
		return Response.ok(navegacao).build(); // estou retornando a navegacao com o ID gerado e salvo no banco
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo) {
		NavegacaoDAO navegacaoDAO = new NavegacaoDAO();
		Navegacao navegacao = navegacaoDAO.buscarPorCodigo(codigo);
		navegacaoDAO.excluir(navegacao);
		return Response.ok(navegacao).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Navegacao navegacao) {
		NavegacaoDAO navegacaoDAO = new NavegacaoDAO();
		navegacaoDAO.editar(navegacao);
		return Response.ok(navegacao).build();
	}
}
