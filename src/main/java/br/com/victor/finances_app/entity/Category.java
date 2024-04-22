package br.com.victor.finances_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String categoryType;
    @OneToOne
    @JoinColumn(name="users", referencedColumnName="ID")
    private Long userId;
}
