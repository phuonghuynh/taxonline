package com.taxonline.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxonline.core.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

   Employee findByTaxcode(String taxcode);

}
