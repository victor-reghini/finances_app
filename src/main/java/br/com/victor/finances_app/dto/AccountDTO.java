package br.com.victor.finances_app.dto;

import br.com.victor.finances_app.entity.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class AccountDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String user;
    private Float balance;
    private String status;

    public AccountDTO fromAccount(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.id = account.getId();
        accountDTO.name = account.getName();
        accountDTO.description = account.getDescription();
        accountDTO.user = account.getUser().getName();
        accountDTO.balance = account.getBalance();
        accountDTO.status = account.getStatus();
        return accountDTO;
    }

    public ObjectMapper createObjectMapper() {
        return new ObjectMapper()
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
