package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.dto.ExpenseDTO;
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
    ExpenseDTO create(@RequestBody @Valid Expense expense){
        return new ExpenseDTO().fromExpense(expenseService.create(expense));
    }

    @PostMapping("/batch")
    List<ExpenseDTO> createMany(@RequestBody @Valid List<Expense> expenses){
        return expenseService.createMany(expenses).stream().map(expense -> new ExpenseDTO().fromExpense(expense)).toList();
    }

    @PutMapping
    ExpenseDTO update(@RequestBody @Valid Expense expense){
        return new ExpenseDTO().fromExpense(expenseService.update(expense));
    }

    @GetMapping(path = "/list")
    List<ExpenseDTO> getAll(@RequestParam Long userId, @RequestParam(required = false) Long accountId,
                            @RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate){
        return expenseService.getAll(userId, accountId, startDate, endDate).stream().map(expense -> new ExpenseDTO().fromExpense(expense)).toList();
    }

    @GetMapping(path = "/{id}")
    Optional<ExpenseDTO> getById(@PathVariable Long id){
        return Optional.ofNullable(new ExpenseDTO().fromExpense(expenseService.getById(id).get()));
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        expenseService.delete(id);
    }
}
