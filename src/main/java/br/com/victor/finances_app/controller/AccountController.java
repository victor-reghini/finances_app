package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.entity.Account;
import br.com.victor.finances_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    Account create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @PutMapping
    Account update(@RequestBody Account account) {
        return accountService.update(account);
    }

    @GetMapping(path = "/list")
    List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping(path = "/{id}")
    Optional<Account> getById(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id) {
        accountService.delete(id);
    }
}
