package backtobasic.rest.resteasy.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

public interface ResteasyClientInterfaceProxy {
	
	@GET
	@Path("/hello/")
	@Consumes(MediaType.TEXT_PLAIN)
	public String getHelloCruelWorld();

}
