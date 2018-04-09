package dpmm.bsirh.aarhd.ws;

import dpmm.bsirh.aarhd.AARHDao;
import lombok.extern.java.Log;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;


@Path( "tables")
@Log
@RequestScoped
public class TablesWS implements Serializable
{


	@Inject
	private AARHDao dao;

	@GET
	@Produces( MediaType.APPLICATION_JSON)
	public String getUsers()
	{

		return  JsonbBuilder.create().toJson(dao.getAllMappingTable());

	}


	@POST
	@Produces( MediaType.TEXT_HTML)
	public String hello()
	{
		log.info("Call Hi!");
		return "<h1>Hello</h1>";

	}

}
