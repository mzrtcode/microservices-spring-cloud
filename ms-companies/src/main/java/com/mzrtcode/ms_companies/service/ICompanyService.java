package com.mzrtcode.ms_companies.service;


import com.mzrtcode.ms_companies.model.Company;

public interface ICompanyService {

    Company readByName(String name);
    Company create(Company company);
    Company update(Company company, String name);
    void delete(String name);
}
