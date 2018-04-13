package dpmm.bsirh.arhom.ws;


import dpmm.bsirh.arhom.ARHOMDao;
import dpmm.bsirh.arhom.controller.AuthentificateController;
import dpmm.bsirh.buisness.entities.Credentials;
import dpmm.bsirh.buisness.entities.JsonUser;
import dpmm.bsirh.buisness.factory.JsonUserFactory;
import lombok.extern.java.Log;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("users")
@Log
@RequestScoped
public class UtilisateurWS {


    @Inject
    private ARHOMDao dao;

    @Inject
    private AuthentificateController authController;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response auth(String json) {

        String logMessage = "";
      try
      {


          Credentials cred = JsonbBuilder.newBuilder().build().fromJson(json, Credentials.class);
          if(authController.authentificate(cred))
          {


           Optional<String> oToken =  authController.generateToken(cred);


             if(oToken.isPresent())
             {
                 return  Response.ok("[{\"token\":\""+ oToken.get()+"\"}]")
                         .header("Access-Control-Allow-Origin", "*")
                         .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, Access-Control-Allow-Headers, Access-Control-Allow-Methods,Access-Control-Allow-Origin")
                         .header("Access-Control-Allow-Credentials", "true")
                         .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                         .header("Access-Control-Max-Age", "1209600")
                       //  .header("Authorization", "Bearer ".concat(oToken.get()))
                         .build();
             }
             else
             {
                 logMessage = "Impossible de genere le token en JSON ";
             }
          }
          else
          {
              return Response.status(403).build();
          }
      }
      catch(JsonbException ex)
      {
          logMessage ="Impossible de parser en JSON la requete du client";

      }
        log.info(logMessage);
        return Response.serverError().build();

    }

    @OPTIONS
    @Path("/login")
    public Response authOptions() {
        System.out.print("OPTIONS /login");
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, Access-Control-Allow-Headers, Access-Control-Allow-Methods,Access-Control-Allow-Origin")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")

                .build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUtilisateurs() {
        List<JsonUser> users = JsonUserFactory.getUsers(dao.readAll());

        return Response.ok(JsonbBuilder.create().toJson(users), MediaType.APPLICATION_JSON_TYPE)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Content-Type", "application/json")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, Access-Control-Allow-Headers, Access-Control-Allow-Methods,Access-Control-Allow-Origin")

                .build();


    }


}
