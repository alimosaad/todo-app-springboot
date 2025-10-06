package com.example.todo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;
}
