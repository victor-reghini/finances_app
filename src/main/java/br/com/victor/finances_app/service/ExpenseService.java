package br.com.victor.finances_app.service;

import br.com.victor.finances_app.entity.Expense;
import br.com.victor.finances_app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public Expense create(Expense expense){
        return expenseRepository.save(expense);
    }

    public Expense update(Expense expense){
        return expenseRepository.save(expense);
    }

    public List<Expense> getAll(){
        return expenseRepository.findAll();
    }

    public Optional<Expense> getById(Long id){
        return expenseRepository.findById(id);
    }

    public void delete(Long id){
        expenseRepository.deleteById(id);
    }
}
