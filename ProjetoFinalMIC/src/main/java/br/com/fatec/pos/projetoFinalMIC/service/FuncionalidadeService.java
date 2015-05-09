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

import br.com.fatec.pos.projetoFinalMIC.dao.FuncionalidadeDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Funcionalidade;

@Path("/funcionalidade")
public class FuncionalidadeService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		FuncionalidadeDAO funcionalidadeDAO = new FuncionalidadeDAO();
		List<Funcionalidade> funcionalidades = funcionalidadeDAO.listar();
		
		GenericEntity<List<Funcionalidade>> funcionalidadeWrapper = new GenericEntity<List<Funcionalidade>>(funcionalidades){};
		
		return Response.ok(funcionalidadeWrapper).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo){
		FuncionalidadeDAO funcionalidadeDAO = new FuncionalidadeDAO();
		
		Funcionalidade funcionalidade = funcionalidadeDAO.buscarPorCodigo(codigo);
		
		return Response.ok(funcionalidade).build();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Funcionalidade funcionalidade){
		FuncionalidadeDAO funcionalidadeDAO =  new FuncionalidadeDAO();
		
		funcionalidadeDAO.salvar(funcionalidade);
		
		return Response.ok(funcionalidade).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo){
		FuncionalidadeDAO funcionalidadeDAO = new FuncionalidadeDAO();
		
		Funcionalidade funcionalidade = funcionalidadeDAO.buscarPorCodigo(codigo);
		
		funcionalidadeDAO.excluir(funcionalidade);
		
		return Response.ok(funcionalidade).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(Funcionalidade funcionalidade){
		FuncionalidadeDAO funcionalidadeDAO =  new FuncionalidadeDAO();
		
		funcionalidadeDAO.editar(funcionalidade);
		
		return Response.ok(funcionalidade).build();
	}
}








