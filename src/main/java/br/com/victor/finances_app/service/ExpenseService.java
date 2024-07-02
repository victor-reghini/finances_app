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

    public List<Expense> getAll(Long user_id, Long account_id, Date start_date, Date end_date){
        if (user_id != null && account_id != null && start_date != null && end_date != null) {
            return expenseRepository.getAllByUserAccountAndPaymentDueDate(user_id, account_id, start_date, end_date);
        }
        if (user_id != null && start_date != null && end_date != null) {
            return expenseRepository.getAllByUserAndPaymentDueDate(user_id, start_date, end_date);
        }
        if (user_id != null) {
            return expenseRepository.getAllByUser(user_id);
        }
        return expenseRepository.findAll();
    }

    public Optional<Expense> getById(Long id){
        return expenseRepository.findById(id);
    }

    public void delete(Long id){
        expenseRepository.deleteById(id);
    }
}
