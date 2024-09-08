package br.com.victor.finances_app.service;

import br.com.victor.finances_app.entity.Expense;
import br.com.victor.finances_app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Expense> createMany(List<Expense> expenses){
        return expenseRepository.saveAll(expenses);
    }

    public Expense update(Expense expense){
        return expenseRepository.save(expense);
    }

    public List<Expense> getAll(Long userId, Long accountId, Date startDate, Date endDate){
        if (userId != null && accountId != null && startDate != null && endDate != null) {
            return expenseRepository.getAllByUserAccountAndPaymentDueDate(userId, accountId, startDate, endDate);
        }
        if (userId != null && startDate != null && endDate != null) {
            return expenseRepository.getAllByUserAndPaymentDueDate(userId, startDate, endDate);
        }
        return expenseRepository.getAllByUser(userId);
    }

    public Optional<Expense> getById(Long id){
        return expenseRepository.findById(id);
    }

    public void delete(Long id){
        expenseRepository.deleteById(id);
    }
}
