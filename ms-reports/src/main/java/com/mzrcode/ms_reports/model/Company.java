package com.mzrcode.ms_reports.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data // Genera los métodos getter, setter, toString, equals y hashCode y un constructor
public class Company {

    private Long id;
    private String name;
    private String founder;
    private String logo;

    // Configura el formato de la fecha al serializar y deserializar JSON, usando el formato "dd/MM/yyyy".
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;

    private List<WebSite> webSites;

}