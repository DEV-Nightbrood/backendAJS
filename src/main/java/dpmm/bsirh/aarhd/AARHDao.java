package dpmm.bsirh.aarhd;

import dpmm.bsirh.aarhd.entities.MappingTable;
import dpmm.bsirh.bdd.annotations.AARHDDataBase;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class AARHDao
{

	@Inject
	@AARHDDataBase
	private EntityManager aarhdEm;


	public List<MappingTable> getAllMappingTable()
	{

		return aarhdEm.createQuery("SELECT m FROM MappingTable m",MappingTable.class)
		              .getResultList();

	}
}
