package ru.emelkrist.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.emelkrist.todoapp.models.TodoItem;

/**
 * Интерфейс - репозиторий для базы данных дел.
 */
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
