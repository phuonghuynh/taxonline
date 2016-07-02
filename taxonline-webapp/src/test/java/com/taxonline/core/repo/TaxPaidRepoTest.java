package com.taxonline.core.repo;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.taxonline.core.domain.Employee;
import com.taxonline.core.domain.TaxPaid;

@DataSet(dtdMetadata = true, locations = "sample-data.xml")
public class TaxPaidRepoTest extends AbstractRepoUnitTest {

   @Resource
   private TaxPaidRepo taxPaidRepo;

   @Resource
   private EmployeeRepo employeeRepo;
   
   @Resource
   private CurrencyEntityRepo currencyEntityRepo;

   @Test
   public void testCreateNew() {
      List<Employee> employees = employeeRepo.findAll();
      Employee employee = employees.get(0);
      TaxPaid taxPaid = new TaxPaid(10, 2012, employee);
      taxPaid.setAmount(23.6);
      taxPaidRepo.saveAndFlush(taxPaid);
   }

   @Test
   public void testFindByMonthAndYear() {
//      testCreateNew();
//      List<Employee> employees = employeeRepo.findAll();
//      Employee employee = employees.get(0);
//      TaxPaid taxpaid = (TaxPaid) currencyEntityRepo.findByMonthAndYear(TaxPaid.class, 10, 2012, employee.getId());
//      Assert.assertTrue(taxpaid != null);
   }
}
