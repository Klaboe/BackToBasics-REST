package backtobasic.rest.resteasy.client;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

public class ResteasyClientImpl {
	
	public String getHelloworld() {
		ClientConnectionManager cm = new ThreadSafeClientConnManager();
		HttpClient httpClient = new DefaultHttpClient(cm);
		ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
		ResteasyClient client = new ResteasyClientBuilder().httpEngine(engine).build();
		
		ResteasyWebTarget webTarget = client.target("http://localhost:9001");
		
		ResteasyClientInterfaceProxy proxy = webTarget.proxy(ResteasyClientInterfaceProxy.class);
		
		String hello = proxy.getHelloCruelWorld();
		
		return hello;		
	}
	
	
}


