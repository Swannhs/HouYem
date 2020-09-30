package com.example.demo.employee.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee_leave")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String conge;
    private String date_debut;
    private String date_fin;
    private String admin;

    @Type(type = "text")
    private String commentaire;


}
// This is employee leave this class talk to database with employee leave