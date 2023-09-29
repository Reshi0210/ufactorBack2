package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="users_roles",joinColumns = @JoinColumn(name = "users_id"),
               inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Role> roles;
}
