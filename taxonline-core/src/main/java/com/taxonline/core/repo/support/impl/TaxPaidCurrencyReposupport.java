package com.taxonline.core.repo.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.taxonline.core.domain.Employee;
import com.taxonline.core.domain.TaxPaid;
import com.taxonline.core.factory.EntityFactory;
import com.taxonline.core.metadata.CurrencyMetadata;
import com.taxonline.core.repo.EmployeeRepo;
import com.taxonline.core.repo.TaxPaidRepo;
import com.taxonline.core.repo.support.CurrencyEntityReposupport;

@Component
public class TaxPaidCurrencyReposupport implements CurrencyEntityReposupport<TaxPaid> {

   @Resource
   private TaxPaidRepo taxPaidRepo;

   @Resource
   private EmployeeRepo employeeRepo;

   public TaxPaid newEntity(CurrencyMetadata currencyMetadata) {
      Employee employee = employeeRepo.findOne(currencyMetadata.getEmployeeId());
      return EntityFactory.newTaxPaid(currencyMetadata.getMonth(), currencyMetadata.getYear(), employee);
   }

   public TaxPaid save(TaxPaid entity) {
      return taxPaidRepo.save(entity);
   }

}
