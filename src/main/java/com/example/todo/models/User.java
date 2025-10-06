package com.example.todo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String password;
    private String userName;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Category> categories;
}
