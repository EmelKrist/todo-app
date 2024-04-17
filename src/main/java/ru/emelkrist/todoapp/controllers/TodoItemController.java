package ru.emelkrist.todoapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.emelkrist.todoapp.models.TodoItem;
import ru.emelkrist.todoapp.services.TodoItemService;

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


}
