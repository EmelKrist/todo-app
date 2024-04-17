package ru.emelkrist.todoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.emelkrist.todoapp.models.TodoItem;
import ru.emelkrist.todoapp.repositories.TodoItemRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Класс - сервис для работы с делами.
 */
@Service
@Transactional
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    /**
     * Метод для получения писка всех дел.
     *
     * @return список дел
     */
    @Transactional(readOnly = true)
    public List<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    /**
     * Метод для сохранения в БД нового дела.
     *
     * @param todoItem новое дело с данными из формы
     */
    public void save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now());
        }
        todoItem.setUpdatedAt(Instant.now());
        todoItemRepository.save(todoItem);
    }

    /**
     * Метод для удаления из БД дела по его id.
     *
     * @param id идентификатор дела
     */
    public void delete(long id) {
        todoItemRepository.deleteById(id);
    }

    /**
     * Метод для получения дела из БД по id.
     *
     * @param id идентификатор дела
     * @return дело (опционально)
     */
    @Transactional(readOnly = true)
    public Optional<TodoItem> getOne(long id) {
        return todoItemRepository.findById(id);
    }

}
