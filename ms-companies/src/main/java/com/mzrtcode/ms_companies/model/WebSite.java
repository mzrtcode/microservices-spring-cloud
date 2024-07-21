package com.mzrtcode.ms_companies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
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
    @JoinColumn(name = "id_company") // Clave foránea
    @JsonBackReference
    private Company company;


}
