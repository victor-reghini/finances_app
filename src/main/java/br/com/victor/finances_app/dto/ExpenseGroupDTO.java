package br.com.victor.finances_app.dto;

import br.com.victor.finances_app.entity.ExpenseGroup;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ExpenseGroupDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String user;

    public ExpenseGroupDTO fromExpenseGroup(ExpenseGroup expenseGroup) {
        ExpenseGroupDTO expenseGroupDTO = new ExpenseGroupDTO();
        expenseGroupDTO.id = expenseGroup.getId();
        expenseGroupDTO.name = expenseGroup.getName();
        expenseGroupDTO.description = expenseGroup.getDescription();
        expenseGroupDTO.user = expenseGroup.getUser().getName();
        return expenseGroupDTO;
    }
}
