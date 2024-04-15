package ru.emelkrist.todoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emelkrist.todoapp.models.TodoItem;
import ru.emelkrist.todoapp.repositories.TodoItemRepository;

import java.util.List;

/**
 * Класс - сервис для работы с делами.
 */
@Service
public class TodoItemService {

    private TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    /**
     * Метод для получения писка всех дел.
     *
     * @return список дел
     */
    public List<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }
}
