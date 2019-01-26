package nl.ou.sut.rest.todos;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Arjan Gerritsen
 *
 */
@Path("/todos")
@Produces({ "application/json", "application/xml" })
public class TodoResource {

	@GET
	public Response getTodos() {
		return Response.ok().build();
	}

	@GET
	@Path("/{id}")
	public Response getTodo(@PathParam("id") String id) {
		return Response.ok().build();
	}

	@POST
	public Response addTodo(@FormParam("description") String description) {
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	public Response updateTodo(@PathParam("id") String id) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTodo(@PathParam("id") String id) {
		return Response.ok().build();
	}
}