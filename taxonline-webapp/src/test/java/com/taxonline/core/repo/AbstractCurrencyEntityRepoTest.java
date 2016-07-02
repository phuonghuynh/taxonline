package com.taxonline.core.repo;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.taxonline.core.domain.Employee;
import com.taxonline.core.domain.TaxPaid;
import com.taxonline.core.repo.support.impl.TaxPaidCurrencyReposupport;

@DataSet(dtdMetadata = true, locations = "sample-data.xml")
public class AbstractCurrencyEntityRepoTest extends AbstractRepoUnitTest {

   @Resource
   private CurrencyEntityRepo currencyEntityRepo;

   @Resource
   private TaxPaidRepo taxPaidRepo;

   @Resource
   private EmployeeRepo employeeRepo;

   @Resource
   private ApplicationContext appContext;
   
   @Resource
   private TaxPaidCurrencyReposupport taxPaidCurrencyReposupport;

   @Test
   public void testFindByMonthAndYear() {
//      List<Employee> employees = employeeRepo.findAll();
//      Employee employee = employees.get(0);
//      TaxPaid taxPaid = new TaxPaid(10, 2012, employee);
//      taxPaid.setAmount(23.6);
//      taxPaidRepo.saveAndFlush(taxPaid);
//      TaxPaid taxpaid = (TaxPaid) currencyEntityRepo.findByMonthAndYear(TaxPaid.class, 10, 2012, employee.getId());
//      Assert.assertTrue(taxpaid != null);
//      appContext.getBean("abcdef")
//      System.out.println(taxPaidCurrencyReposupport.getBeanName());
   }
}
