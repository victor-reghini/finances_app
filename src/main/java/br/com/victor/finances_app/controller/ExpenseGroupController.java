package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.dto.ExpenseGroupDTO;
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
    ExpenseGroupDTO create(@RequestBody @Valid ExpenseGroup expenseGroup){
        return new ExpenseGroupDTO().fromExpenseGroup(expenseGroupService.create(expenseGroup));
    }

    @PutMapping
    ExpenseGroupDTO update(@RequestBody @Valid ExpenseGroup expenseGroup){
        return new ExpenseGroupDTO().fromExpenseGroup(expenseGroupService.update(expenseGroup));
    }

    @GetMapping(path = "/list")
    List<ExpenseGroupDTO> getAll(@RequestParam Long userId){
        return expenseGroupService.getAll(userId).stream().map(expenseGroup -> new ExpenseGroupDTO().fromExpenseGroup(expenseGroup)).toList();
    }

    @GetMapping(path = "/{id}")
    Optional<ExpenseGroupDTO> getUser(@PathVariable Long id){
        return Optional.ofNullable(new ExpenseGroupDTO().fromExpenseGroup(expenseGroupService.getById(id).get()));
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        expenseGroupService.delete(id);
    }
}
