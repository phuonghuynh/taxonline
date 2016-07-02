package com.taxonline.core.repo.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.taxonline.core.domain.CompulsoryContribution;
import com.taxonline.core.domain.Employee;
import com.taxonline.core.factory.EntityFactory;
import com.taxonline.core.metadata.CurrencyMetadata;
import com.taxonline.core.repo.CompulsoryContributionRepo;
import com.taxonline.core.repo.EmployeeRepo;
import com.taxonline.core.repo.support.CurrencyEntityReposupport;

@Component
public class CompulsoryContributionCurrencyReposupport implements CurrencyEntityReposupport<CompulsoryContribution> {

   @Resource
   private CompulsoryContributionRepo compulsoryContributionRepo;

   @Resource
   private EmployeeRepo employeeRepo;

   public CompulsoryContribution newEntity(CurrencyMetadata currencyMetadata) {
      Employee employee = employeeRepo.findOne(currencyMetadata.getEmployeeId());
      return EntityFactory.newCompulsoryContribution(currencyMetadata.getMonth(), currencyMetadata.getYear(), employee);
   }

   public CompulsoryContribution save(CompulsoryContribution entity) {
      return compulsoryContributionRepo.save(entity);
   }

}
