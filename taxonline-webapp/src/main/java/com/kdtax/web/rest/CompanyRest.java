package com.kdtax.web.rest;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxonline.core.domain.Company;
import com.taxonline.core.dto.CompanyDto;
import com.taxonline.core.repo.CompanyRepo;

@Controller
@RequestMapping("company")
public class CompanyRest extends AbstractCrudRest<Company, CompanyDto> {

   @Resource
   private CompanyRepo companyRepo;

   public JpaRepository<Company, Long> getRepo() {
      return companyRepo;
   }

}
