package dpmm.bsirh.arhom;

import dpmm.bsirh.aarhd.entities.MappingTable;
import dpmm.bsirh.arhom.entities.Utilisateur;
import dpmm.bsirh.bdd.annotations.ARHOMDataBase;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class ARHOMDao
{

	@Inject
	@ARHOMDataBase
	private EntityManager arhomEm;


	public Utilisateur getUserByIdentifiant( String id )
	{

		return arhomEm.createQuery("SELECT u FROM Utilisateur u where u.identifiant = :IDENT", Utilisateur.class)
		              .setParameter("IDENT", id)
		              .getSingleResult();

	}

	public List<Utilisateur> readAll()
	{
		return arhomEm.createQuery("SELECT u FROM Utilisateur u ", Utilisateur.class)
		              .getResultList();
	}
}
