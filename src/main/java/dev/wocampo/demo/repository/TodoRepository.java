package dev.wocampo.demo.repository;

import dev.wocampo.demo.model.Todo;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@Dependent
public class TodoRepository {
    @Inject
    EntityManager entityManager;

    public List<Todo> findALl() {
        return entityManager
                .createQuery("SELECT t from Todo t", Todo.class)
                .getResultList();
    }

    public void save(Todo todo) {
        entityManager.persist(todo);
    }

    public Todo find(Long todoId) {
        return entityManager.find(Todo.class, todoId);
    }

    public void update(Todo todo) {
        entityManager.merge(todo);
    }

    public void delete(Long todoId) {
        Todo todo = entityManager.find(Todo.class, todoId);
        if (todo != null) {
            entityManager.remove(todo);
        }
    }
}
