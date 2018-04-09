package dpmm.bsirh.arhom.ws;


import dpmm.bsirh.arhom.ARHOMDao;
import dpmm.bsirh.buisness.entities.JsonUser;
import dpmm.bsirh.buisness.factory.JsonUserFactory;
import lombok.extern.java.Log;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path( "users")
@Log
@RequestScoped
public class UtilisateurWS
{


	@Inject
	private ARHOMDao dao;

	@POST
	@Produces(MediaType.TEXT_PLAIN )
	@Path("/login")
	public Response auth( @FormParam("identifiant")String identifiant, @FormParam("password") String password )
	{
		System.out.println("Tentative de connexion user : " + identifiant + " password : " + password);

		return Response.ok("User"+identifiant+" Allowed").build();

	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON )
	public Response listUtilisateurs()
	{
		List<JsonUser> users = JsonUserFactory.getUsers(dao.readAll());

		return Response.ok(JsonbBuilder.create().toJson(users),MediaType.APPLICATION_JSON_TYPE)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
				.build();





	}


}
