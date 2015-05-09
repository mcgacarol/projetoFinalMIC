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

import br.com.fatec.pos.projetoFinalMIC.dao.UsuarioDAO;
import br.com.fatec.pos.projetoFinalMIC.domain.Usuario;

@Path("/usuario")
public class UsuarioService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.listar();
		
		GenericEntity<List<Usuario>> usuarioWrapper = new GenericEntity<List<Usuario>>(usuarios){};
		
		return Response.ok(usuarioWrapper).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("codigo") Integer codigo){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = usuarioDAO.buscarPorCodigo(codigo);
		
		return Response.ok(usuario).build();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Usuario usuario){
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		
		usuarioDAO.salvar(usuario);
		
		return Response.ok(usuario).build();
	}
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("codigo") Integer codigo){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = usuarioDAO.buscarPorCodigo(codigo);
		
		usuarioDAO.excluir(usuario);
		
		return Response.ok(usuario).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(Usuario usuario){
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		
		usuarioDAO.editar(usuario);
		
		return Response.ok(usuario).build();
	}
}



