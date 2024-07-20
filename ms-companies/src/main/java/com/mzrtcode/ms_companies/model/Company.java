package com.mzrtcode.ms_companies.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "company")
@Data // Genera los métodos getter, setter, toString, equals y hashCode y un constructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String founder;
    private String logo;

    // Configura el formato de la fecha al serializar y deserializar JSON, usando el formato "dd/MM/yyyy".
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "company", // Nombre del campo en WebSite
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonManagedReference
    private List<WebSite> webSites;

}