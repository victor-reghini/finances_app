package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.dto.UserDTO;
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
    UserDTO create(@RequestBody @Valid User user){
        return new UserDTO().fromUser(userService.create(user));
    }

    @PutMapping
    UserDTO update(@RequestBody @Valid User user){
        return new UserDTO().fromUser(userService.update(user));
    }

    @GetMapping(path = "/list")
    List<UserDTO> getAll(){
        return userService.getAll().stream().map(user-> new UserDTO().fromUser(user)).toList();
    }

    @GetMapping(path = "/{id}")
    Optional<UserDTO> getUser(@PathVariable Long id){
        return Optional.ofNullable(new UserDTO().fromUser(userService.getById(id).get()));
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
