package dev.wocampo.demo.resources;

import dev.wocampo.demo.model.Todo;
import dev.wocampo.demo.repository.TodoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    @Inject
    TodoRepository todoRepository;

    @GET
    public List<Todo> findAll() {
        return todoRepository.findALl();
    }

    @POST
    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    @GET
    @Path("/{id}")
    public Todo find(@PathParam(value = "id") Long id) {
        return todoRepository.find(id);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam(value = "id") Long id, Todo todo) {
        if (todoRepository.find(id) != null) {
            todo.setTodoId(id);
            todoRepository.update(todo);
        }
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam(value = "id") Long id) {
        todoRepository.delete(id);
    }
}
