package com.mzrcode.ms_reports.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.io.Serializable;

@Data
public class WebSite implements Serializable {

    private Long id;
    private String name;
    private Category category;
    private String description;
    private Company company;


}
