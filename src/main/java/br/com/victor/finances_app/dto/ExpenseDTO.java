package br.com.victor.finances_app.dto;

import br.com.victor.finances_app.entity.Expense;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import static java.util.Objects.nonNull;

@Getter
public class ExpenseDTO implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Float value;
    private Float paidValue;
    private Date paymentDate;
    private Date paymentDueDate;
    private Date purchaseDate;
    private Integer installment;
    private Integer totalInstallments;
    private String paymentType;
    private Long paymentTypeId;
    private String account;
    private Long accountId;
    private String card;
    private Long cardId;
    private String expenseGroup;
    private Long expenseGroupId;
    private String category;
    private Long categoryId;

    public ExpenseDTO fromExpense(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.id = expense.getId();
        expenseDTO.title = expense.getTitle();
        expenseDTO.description = expense.getDescription();
        expenseDTO.status = expense.getStatus();
        expenseDTO.value = expense.getValue();
        expenseDTO.paidValue = expense.getPaidValue();
        expenseDTO.paymentDate = expense.getPaymentDate();
        expenseDTO.paymentDueDate = expense.getPaymentDueDate();
        expenseDTO.purchaseDate = expense.getPurchaseDate();
        expenseDTO.installment = expense.getInstallment();
        expenseDTO.totalInstallments = expense.getTotalInstallments();
        expenseDTO.paymentType = nonNull(expense.getPaymentType()) ? expense.getPaymentType().getName() : null;
        expenseDTO.paymentTypeId = nonNull(expense.getPaymentType()) ? expense.getPaymentType().getId() : null;
        expenseDTO.account = nonNull(expense.getAccount()) ? expense.getAccount().getName() : null;
        expenseDTO.accountId = nonNull(expense.getAccount()) ? expense.getAccount().getId() : null;
        expenseDTO.card = nonNull(expense.getCard()) ? expense.getCard().getName() : null;
        expenseDTO.cardId = nonNull(expense.getCard()) ? expense.getCard().getId() : null;
        expenseDTO.expenseGroup = nonNull(expense.getExpenseGroup()) ? expense.getExpenseGroup().getName() : null;
        expenseDTO.expenseGroupId = nonNull(expense.getExpenseGroup()) ? expense.getExpenseGroup().getId() : null;
        expenseDTO.category = nonNull(expense.getCategory()) ? expense.getCategory().getName() : null;
        expenseDTO.categoryId = nonNull(expense.getCategory()) ? expense.getCategory().getId() : null;
        return expenseDTO;
    }

    public ObjectMapper createObjectMapper() {
        return new ObjectMapper()
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
