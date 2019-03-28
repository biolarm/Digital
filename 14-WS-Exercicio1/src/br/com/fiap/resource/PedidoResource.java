package br.com.fiap.resource;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Path;

import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/pedido")
public class PedidoResource {
	
	private PedidoDAO dao;
	
	public PedidoResource() {
		dao = new PedidoDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}

}
