package com.mzrtcode.ms_companies.service;

import com.mzrtcode.ms_companies.model.Category;
import com.mzrtcode.ms_companies.model.Company;
import com.mzrtcode.ms_companies.repository.ICompanyRepository;
import com.mzrtcode.ms_companies.repository.IWebSiteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements ICompanyService{

    private final ICompanyRepository companyRepository;
    private final IWebSiteRepository webSiteRepository;

    @Override
    public Company readByName(String name) {
        return this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
    }

    public Company create(Company company) {
        // Asignar la propiedad 'company' en cada WebSite y verificar la categoría
        company.getWebSites().forEach(website -> {
            if (Objects.isNull(website.getCategory())) {
                website.setCategory(Category.NONE);
            }
            website.setCompany(company); // Asignar la referencia a 'company'
        });

        return this.companyRepository.save(company);
    }

    @Override
    public Company update(Company company, String name) {
        var companyToUpdate = this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));

        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFoundationDate(company.getFoundationDate());
        companyToUpdate.setFounder(company.getFounder());
        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(String name) {
        var companyToDelete =  this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));

        this.companyRepository.delete(companyToDelete);

    }
}
