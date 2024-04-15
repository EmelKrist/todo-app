package ru.emelkrist.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.emelkrist.todoapp.services.TodoItemService;

/**
 * Класс - контроллер для домашней страницы.
 */
@Controller
public class HomeController {

    @Autowired
    private TodoItemService todoItemService;

    /**
     * Метод для получения домашней страницы со списком всех дел.
     *
     * @return представление с домашней страницей и модель с данными обо всех делах
     */
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }
}


