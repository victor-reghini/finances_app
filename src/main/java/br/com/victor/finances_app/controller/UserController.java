package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.entity.User;
import br.com.victor.finances_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    User create(@RequestBody @Valid User user){
        return userService.create(user);
    }

    @PutMapping
    User update(@RequestBody @Valid User user){
        return userService.update(user);
    }

    @GetMapping(path = "/list")
    List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping(path = "/{id}")
    Optional<User> getUser(@PathVariable Long id){
        return userService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
