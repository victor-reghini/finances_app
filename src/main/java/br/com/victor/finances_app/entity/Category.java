package br.com.victor.finances_app.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name="category_type")
    private String categoryType;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
