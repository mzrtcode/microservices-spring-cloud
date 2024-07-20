package com.mzrtcode.ms_companies.controller;

import com.mzrtcode.ms_companies.model.Company;
import com.mzrtcode.ms_companies.service.ICompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("company")
@Slf4j
@Tag(name = "Companies resource")
public class CompanyController {

    private final ICompanyService companyService;

    @Operation(summary = "Get a company by name")
    @GetMapping("{name}") //EJEMPLO: http://localhost:8080/company/Acme
    public ResponseEntity<Company> getCompanyByName(@PathVariable String name){
        log.info("GET: company {}", name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }

    @Operation(summary = "Create a company from body")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company){
        log.info("POST: company {}", company.getName());
        return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
    }

    @Operation(summary = "Update a company from body")
    @PutMapping("{name}")
    public ResponseEntity<Company> updateCompanyByName(@RequestBody Company company,
                                                       @PathVariable String name){
        log.info("PUT: company {}", name);
        return ResponseEntity.ok(this.companyService.update(company, name));
    }

    @Operation(summary = "Delete a company by name")
    @DeleteMapping("{name}")
    public ResponseEntity<?> deleteCompanyByName(@PathVariable String name){
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }
}
