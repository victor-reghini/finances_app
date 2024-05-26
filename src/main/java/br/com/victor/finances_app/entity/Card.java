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
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name="accounts", referencedColumnName="ID")
    private Long accountId;
    @ManyToOne
    @JoinColumn(name="users", referencedColumnName="ID")
    private Long userId;
    private Date closingDate;
    private String cardType;
}
