package backtobasic.rest.jersey.server;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyJerseyServer {
	
	public static void main(String[] args) {
		Server server = new Server(9001);
		ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		
		contextHandler.setContextPath("/");
		
		ServletHolder holder = new ServletHolder(new ServletContainer());
		
		holder.setInitParameter("javax.ws.rs.Application", "backtobasic.rest.div.Services");
		contextHandler.addServlet(holder, "/*");
		server.setHandler(contextHandler);
		
		try {
			server.start();
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
