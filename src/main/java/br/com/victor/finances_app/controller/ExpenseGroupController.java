package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.entity.ExpenseGroup;
import br.com.victor.finances_app.service.ExpenseGroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("expenseGroup")
public class ExpenseGroupController {
    @Autowired
    private ExpenseGroupService expenseGroupService;

    public ExpenseGroupController(ExpenseGroupService expenseGroupService) {
        this.expenseGroupService = expenseGroupService;
    }

    @PostMapping
    ExpenseGroup create(@RequestBody @Valid ExpenseGroup expenseGroup){
        return expenseGroupService.create(expenseGroup);
    }

    @PutMapping
    ExpenseGroup update(@RequestBody @Valid ExpenseGroup expenseGroup){
        return expenseGroupService.update(expenseGroup);
    }

    @GetMapping(path = "/list")
    List<ExpenseGroup> getAll(){
        return expenseGroupService.getAll();
    }

    @GetMapping(path = "/{id}")
    Optional<ExpenseGroup> getUser(@PathVariable Long id){
        return expenseGroupService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        expenseGroupService.delete(id);
    }
}
