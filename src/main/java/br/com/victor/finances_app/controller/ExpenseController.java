package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.entity.Expense;
import br.com.victor.finances_app.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping("/batch")
    List<Expense> createMany(@RequestBody @Valid List<Expense> expenses){
        return expenseService.createMany(expenses);
    }

    @PutMapping
    Expense update(@RequestBody @Valid Expense expense){
        return expenseService.update(expense);
    }

    @GetMapping(path = "/list")
    List<Expense> getAll(@RequestParam(required = false) Long user_id,
                         @RequestParam(required = false) Long account_id,
                         @RequestParam(required = false) Date start_date,
                         @RequestParam(required = false) Date end_date){
        return expenseService.getAll(user_id, account_id, start_date, end_date);
    }

    @GetMapping(path = "/{id}")
    Optional<Expense> getById(@PathVariable Long id){
        return expenseService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        expenseService.delete(id);
    }
}
