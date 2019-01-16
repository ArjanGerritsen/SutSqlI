package nl.ou.sut;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * 
 * @author Arjan Gerritsen
 *
 */
public class App {

	public static void main(String[] args) {
		Server server = new Server(8080);

		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

		servletContextHandler.setContextPath("/");
		server.setHandler(servletContextHandler);

		ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/api/*");
		servletHolder.setInitOrder(0);
		servletHolder.setInitParameter("jersey.config.server.provider.packages", "nl.ou.sut.rest");

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			System.exit(1);
		} finally {
			server.destroy();
		}
	}
}