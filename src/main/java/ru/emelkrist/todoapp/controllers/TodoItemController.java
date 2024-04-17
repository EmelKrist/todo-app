package ru.emelkrist.todoapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.emelkrist.todoapp.models.TodoItem;
import ru.emelkrist.todoapp.services.TodoItemService;

import java.util.Optional;

/**
 * Класс - контроллер для запросов на действия над делами.
 */
@Controller
@RequestMapping("/todos")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    /**
     * Метод для получения списка всех дел.
     *
     * @return редирект на главную страницу
     */
    @GetMapping()
    public String getAll() {
        return "redirect:/";
    }

    /**
     * Метод для получения страницы создания нового дела.
     *
     * @param model модель представления
     * @return форма добавления нового дела
     */
    @GetMapping("new")
    public String newTodo(Model model) {
        model.addAttribute("todoItem", new TodoItem());
        return "new";
    }

    /**
     * Метод для создания нового дела.
     *
     * @param todoItem      книга с данными из формы для добавления в БД
     * @param bindingResult объект с результатами заполнения полей данных
     * @return в случае ошибки возвращение к странице добавления, иначе редирект на главную страницу
     */
    @PostMapping()
    public String create(@ModelAttribute("todoItem") @Valid TodoItem todoItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }

        todoItemService.save(todoItem);
        return "redirect:/";
    }

    /**
     * Метод для удаления дела.
     *
     * @param todoId идентификатор удаляемого дела
     * @return редирект на главную страницу
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") long todoId) {
        todoItemService.delete(todoId);
        return "redirect:/";
    }

    /**
     * Метод для получения страницы редактирования дела.
     *
     * @param id    идентификатор дела
     * @param model модель представление
     * @return редирект на главную страницу
     */
    @GetMapping("{id}/edit")
    public String editTodoPage(@PathVariable("id") long id, Model model) {
        Optional<TodoItem> todoItem = todoItemService.getOne(id);
        if (todoItem.isPresent()) {
            model.addAttribute("todoItem", todoItem.get());
            return "edit";
        }
        return "redirect:/";
    }

    /**
     * Метод для обновления дела.
     *
     * @param id              идентификатор дела
     * @param updatedTodoItem дело с обновленными данными
     * @param bindingResult   объект с результатами заполнения полей данных
     * @return в случае ошибки возвращение к странице редактирования, иначе редирект на главную страницу
     */
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") long id,
                         @ModelAttribute("todoItem") @Valid TodoItem updatedTodoItem,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        todoItemService.save(updatedTodoItem);
        return "redirect:/";
    }
}
