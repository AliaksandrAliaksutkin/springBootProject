package org.example.springbootproject.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springbootproject.exception.NoEntityException;
import org.example.springbootproject.model.Address;
import org.example.springbootproject.model.User;
import org.example.springbootproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/homepage") // /homepage; url - который приводит в данный метод контроллера
    public String viewHomePage(Model model) {
        List<User> listUsers = userService.getAllUsers();
        model.addAttribute("listUser", listUsers); // ключ/значение
        return "users";   // имя представления в который преведет данный метод
    }

    @GetMapping("/address")
    public String getAddress(Model model, @RequestParam Long id) throws NoEntityException {
        User address = userService.getById(id);
        model.addAttribute("address", address);
        return "address";
    }

    @PostMapping("allusers")
    public String editUser(@RequestParam (required = false)Long id, /*Конструкция require=false сообщает фреймворку о том, что наличие соответствующего bean'а не является обязательным при компиляции программы.*/
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam Integer age,
                           @RequestParam(name = "address.city") String city,
                           @RequestParam(name = "address.street") String street,
                           @RequestParam(name = "address.house") Integer house) {
        User user = new User(id, firstName, lastName, age, new Address(city, street, house));
        userService.save(user);
        return "redirect:/homepage";
    }

    @GetMapping(value = "new")
    public String userCreate(Model model, User user) {
        model.addAttribute(user);
        return "new";
    }

    @GetMapping("/update")
    public String updateUser(Model model, @RequestParam Long id) throws NoEntityException {
        model.addAttribute(userService.getById(id));
        return "new";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/homepage";
    }
}
