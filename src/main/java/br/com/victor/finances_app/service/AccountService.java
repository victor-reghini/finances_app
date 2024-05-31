package br.com.victor.finances_app.service;

import br.com.victor.finances_app.entity.Account;
import br.com.victor.finances_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account create(Account account){
        return accountRepository.save(account);
    }

    public Account update(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Optional<Account> getById(Long id){
        return accountRepository.findById(id);
    }

    public void delete(Long id){
        accountRepository.deleteById(id);
    }
}
