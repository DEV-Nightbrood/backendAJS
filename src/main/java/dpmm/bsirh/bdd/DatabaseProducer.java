package dpmm.bsirh.bdd;

import dpmm.bsirh.bdd.annotations.AARHDDataBase;
import dpmm.bsirh.bdd.annotations.ARHOMDataBase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ApplicationScoped
public class DatabaseProducer implements Serializable
{

	@Produces
	@AARHDDataBase
	@PersistenceContext(unitName = "AARHD",name = "AARHD")
	private EntityManager aarhdEm;

	@Produces
	@ARHOMDataBase
	@PersistenceContext(unitName = "ARHOM",name = "ARHOM")
	private EntityManager arhomEM;
}
