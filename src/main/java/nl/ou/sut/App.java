package nl.ou.sut;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * 
 * @author Arjan Gerritsen
 *
 */
public class App {

	public static void main(String[] args) {
		// Servlets
		ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
		servletContext.setContextPath("/api");
		ServletHolder servletHolder = servletContext.addServlet(ServletContainer.class, "/*");
		servletHolder.setInitParameter("jersey.config.server.provider.packages",
				"io.swagger.v3.jaxrs2.integration.resources, io.swagger.sample.resource,nl.ou.sut.rest");

		// Resources
		ContextHandler resourceContext = new ContextHandler();
		resourceContext.setContextPath("/");
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setResourceBase("openapi");
		resourceContext.setHandler(resourceHandler);

		// Attach to server
		HandlerCollection handlers = new HandlerCollection();
		handlers.addHandler(servletContext);
		handlers.addHandler(resourceContext);

		Server server = new Server(8080);
		server.setHandler(handlers);

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