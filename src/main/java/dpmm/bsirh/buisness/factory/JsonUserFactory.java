package dpmm.bsirh.buisness.factory;

import dpmm.bsirh.arhom.entities.Utilisateur;
import dpmm.bsirh.buisness.entities.JsonUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonUserFactory
{
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public static List<JsonUser> getUsers( List<Utilisateur> listUsers )
	{

		List<JsonUser> retour = new ArrayList<>();

		listUsers.forEach( user ->
			createJsonUser(user).ifPresent(retour::add)
		);

		return retour;
	}

	public static Optional<JsonUser> createJsonUser( Utilisateur user )
	{

		JsonUser retour = new JsonUser();

		retour.setId(user.getIdUtilisateur());
		retour.setDateFin(format.format(user.getDateFin()));
		retour.setIdentifiant(user.getIdentifiant());
		retour.setIdSap(user.getIdIndividu());

		return Optional.of(retour);

	}

}
