package backtobasic.rest.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class RestServerServices {
	
	private List<String> nameList = new ArrayList<String>();
	
	public RestServerServices() { }
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHelloWord() {
		return Response.status(200).entity("Heeeeelllo cruel world!").build();
	}
	
	@GET
	@Path("/hello/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHelloWorldName(@PathParam("name") String name) {
		return Response.status(200).entity("Heeeeelllo cruel world! This is " + name + " cursing you!").build();
	}
	
	@PUT
	@Path("/hello/addname/{name}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void addName(@PathParam("name") String name) {
		nameList.add(name);
	}
	
	@GET
	@Path("/hello/allnames")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllNames() {
		StringBuilder sBuilder = new StringBuilder();
		
		sBuilder.append("HEI");
		
		for(String s : nameList) { 
			sBuilder.append(" " + s).append(",");
		}
		
		if (!nameList.isEmpty()) {
			return Response.status(200)
					.entity(sBuilder.substring(0, sBuilder.length() - 1) + ".")
					.build();
		}
		
		return Response.status(200).entity(sBuilder.toString()).build();
	}
}
