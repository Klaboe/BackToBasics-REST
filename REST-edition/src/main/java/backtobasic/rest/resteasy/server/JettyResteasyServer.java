package backtobasic.rest.resteasy.server;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class JettyResteasyServer {
	
	public static void main(String[] args) {
		Server server = new Server(9001);
		ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		
		contextHandler.setContextPath("/");
		
		ServletHolder holder = new ServletHolder(new HttpServletDispatcher());
		
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
