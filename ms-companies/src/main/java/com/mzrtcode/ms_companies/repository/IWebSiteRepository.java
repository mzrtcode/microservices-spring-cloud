package com.mzrtcode.ms_companies.repository;

import com.mzrtcode.ms_companies.model.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWebSiteRepository extends JpaRepository<WebSite, Long> {
}
