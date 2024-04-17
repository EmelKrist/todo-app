package ru.emelkrist.todoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.emelkrist.todoapp.models.TodoItem;
import ru.emelkrist.todoapp.repositories.TodoItemRepository;

import java.util.List;

/**
 * Класс - сервис для работы с делами.
 */
@Service
@Transactional
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

}
