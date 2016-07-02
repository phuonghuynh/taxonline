package com.taxonline.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxonline.core.domain.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {

}
