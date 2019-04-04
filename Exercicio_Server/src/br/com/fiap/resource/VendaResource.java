package br.com.fiap.resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.VendaDAO;
import br.com.fiap.ws.dao.impl.VendaDAOImpl;
import br.com.fiap.ws.entity.Venda;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/venda")
public class VendaResource {
	
	private VendaDAO dao;
	
	public VendaResource() {
		
		dao = new VendaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager()); 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venda> buscar() {
		return dao.listar();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Venda busca(@PathParam("id") int codigo) {
		try {
			return dao.buscar(codigo);
		} catch (Exception e) {
			return null;
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Venda venda, @Context UriInfo url) {
		
		try {
			dao.cadastrar(venda);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();// 500
		}
		return null;
		
	}
	
	
	
}
