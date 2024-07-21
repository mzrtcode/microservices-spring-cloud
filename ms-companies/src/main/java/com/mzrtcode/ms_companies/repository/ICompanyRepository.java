package com.mzrtcode.ms_companies.repository;

import com.mzrtcode.ms_companies.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

}
