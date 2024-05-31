package br.com.victor.finances_app.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
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

    @Column(name="paid_value")
    private Float paidValue;

    @Column(name="payment_date")
    private Date paymentDate;

    @Column(name="payment_due_date")
    private Date paymentDueDate;

    @Column(name="purchase_date")
    private Date purchaseDate;

    private Integer installment;

    @Column(name="total_installments")
    private Integer totalInstallments;

    @ManyToOne
    @JoinColumn(name="payment_type_id")
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name="card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="expense_group_id")
    private ExpenseGroup expenseGroup;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
