package com.kdtax.web.rest;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxonline.core.domain.Employee;
import com.taxonline.core.dto.EmployeeDto;
import com.taxonline.core.repo.EmployeeRepo;

@Controller
@RequestMapping("employee")
public class EmployeeRest extends AbstractCrudRest<Employee, EmployeeDto> {

   @Resource
   private EmployeeRepo employeeRepo;

   public JpaRepository<Employee, Long> getRepo() {
      return employeeRepo;
   }

}
