package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.dto.AccountDTO;
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
    AccountDTO create(@RequestBody Account account) {
        return new AccountDTO().fromAccount(accountService.create(account));
    }

    @PutMapping
    AccountDTO update(@RequestBody Account account) {
        return new AccountDTO().fromAccount(accountService.update(account));
    }

    @GetMapping(path = "/list")
    List<AccountDTO> getAll(@RequestParam Long userId) {
        return accountService.getAllByUserId(userId).stream().map(account-> new AccountDTO().fromAccount(account)).toList();
    }

    @GetMapping(path = "/{id}")
    Optional<AccountDTO> getById(@PathVariable Long id) {
        return Optional.ofNullable(new AccountDTO().fromAccount(accountService.getById(id).get()));
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id) {
        accountService.delete(id);
    }
}
