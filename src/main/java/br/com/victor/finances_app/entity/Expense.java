package br.com.victor.finances_app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name="payment_types", referencedColumnName="ID")
    private String paymentTypeId;
    @ManyToOne
    @JoinColumn(name="accounts", referencedColumnName="ID")
    private String accountId;
    @ManyToOne
    @JoinColumn(name="cards", referencedColumnName="ID")
    private String cardId;
    @ManyToOne
    @JoinColumn(name="users", referencedColumnName="ID")
    private String userId;
    @ManyToOne
    @JoinColumn(name="expense_group", referencedColumnName="ID")
    private String expenseGroupId;
    @ManyToOne
    @JoinColumn(name="categories", referencedColumnName="ID")
    private String categoryId;
}
