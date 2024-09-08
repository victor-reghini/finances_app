package br.com.victor.finances_app.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="closing_date")
    private Integer closingDate;

    @Column(name="card_type")
    private String cardType;
}
