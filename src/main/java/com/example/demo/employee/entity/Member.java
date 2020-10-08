package com.example.demo.employee.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "member_list")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false, unique = true)
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private String address;
    private String birthdate;
    private String password;
    private String fonction;
    private String gender;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "Role"
    )
    private Collection<Role> roles;
}
