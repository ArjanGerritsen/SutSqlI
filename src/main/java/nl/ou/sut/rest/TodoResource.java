package nl.ou.sut.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * 
 * @author Arjan Gerritsen
 *
 */
@Path("/todos")
public class TodoResource {

	@GET
	public String getTodos() {
		return "test";
	}

	@GET
	@Path("/{id}")
	public String getTodo(@PathParam("id") String id) {
		return "test" + id;
	}
	
	@POST
	public String addTodo() {
		return "test";		
	}

	@PUT
	@Path("/{id}")
	public String updateTodo(@PathParam("id") String id) {
		return "test";		
	}
	
	@DELETE
	@Path("/{id}")
	public String deleteTodo(@PathParam("id") String id) {
		return "test";		
	}	
}