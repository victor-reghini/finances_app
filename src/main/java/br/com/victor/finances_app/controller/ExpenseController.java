package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.entity.Expense;
import br.com.victor.finances_app.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    Expense create(@RequestBody @Valid Expense expense){
        return expenseService.create(expense);
    }

    @PutMapping
    Expense update(@RequestBody @Valid Expense expense){
        return expenseService.update(expense);
    }

    @GetMapping(path = "/list")
    List<Expense> getAll(){
        return expenseService.getAll();
    }

    @GetMapping(path = "/{id}")
    Optional<Expense> getUser(@PathVariable Long id){
        return expenseService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        expenseService.delete(id);
    }
}
