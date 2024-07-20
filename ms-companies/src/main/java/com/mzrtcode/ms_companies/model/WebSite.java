package com.mzrtcode.ms_companies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "website")
@Data
public class WebSite implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Almacena el enum 'Category' como una cadena en la base de datos
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private String description;

    @ManyToOne
    private Company company;


}
