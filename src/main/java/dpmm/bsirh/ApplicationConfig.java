package dpmm.bsirh;

import dpmm.bsirh.aarhd.ws.TablesWS;
import dpmm.bsirh.arhom.ws.UtilisateurWS;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ApplicationPath("rest")
public class ApplicationConfig extends Application
{

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> classes = new HashSet<Class<?>>();

		classes.add(TablesWS.class);
		classes.add(UtilisateurWS.class);

		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return Collections.emptySet();
	}

	@Override
	public Map<String, Object> getProperties() {
		return Collections.emptyMap();
	}

}
