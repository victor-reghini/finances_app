package br.com.victor.finances_app.service;

import br.com.victor.finances_app.entity.ExpenseGroup;
import br.com.victor.finances_app.repository.ExpenseGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseGroupService {
    @Autowired
    private ExpenseGroupRepository expenseGroupRepository;

    public ExpenseGroupService(ExpenseGroupRepository expenseGroupRepository){
        this.expenseGroupRepository = expenseGroupRepository;
    }

    public ExpenseGroup create(ExpenseGroup expenseGroup){
        return expenseGroupRepository.save(expenseGroup);
    }

    public ExpenseGroup update(ExpenseGroup expenseGroup){
        return expenseGroupRepository.save(expenseGroup);
    }

    public List<ExpenseGroup> getAll(){
        return expenseGroupRepository.findAll();
    }

    public Optional<ExpenseGroup> getById(Long id){
        return expenseGroupRepository.findById(id);
    }

    public void delete(Long id){
        expenseGroupRepository.deleteById(id);
    }
}
