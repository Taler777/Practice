package spring_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_test.services.UserService;

@Controller // любой метод контроллера для себя ищет представления

// класс для описания логики
public class GeekbrainsController {
    @Autowired
    UserService service;

    @RequestMapping("/") // метод должен обрабатывать корневой URL
    public String index(
            @RequestParam("str") String str,
            Model model) {
        model.addAttribute("str", str);
        model.addAttribute("users", service.getUsers());
        return "index";
    }
}
