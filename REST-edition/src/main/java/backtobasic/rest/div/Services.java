package backtobasic.rest.div;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import backtobasic.rest.jaxrs.RestServerServices;

public class Services extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	
	public Services() {
		singletons.add(new RestServerServices());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
