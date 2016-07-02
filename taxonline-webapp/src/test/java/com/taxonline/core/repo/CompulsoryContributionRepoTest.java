package com.taxonline.core.repo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.taxonline.core.domain.CompulsoryContribution;
import com.taxonline.core.domain.Employee;

@DataSet(dtdMetadata = true, locations = "sample-data.xml")
public class CompulsoryContributionRepoTest extends AbstractRepoUnitTest {

   @Resource
   private CompulsoryContributionRepo compulsoryContributionRepo;

   @Resource
   private EmployeeRepo employeeRepo;

   @Test
   public void testCreateNew() {
      List<Employee> employees = employeeRepo.findAll();
      Employee employee = employees.get(0);
      CompulsoryContribution compulsoryContribution = new CompulsoryContribution(10, 2012, employee);
      compulsoryContribution.setAmount(12.5);
      compulsoryContributionRepo.saveAndFlush(compulsoryContribution);
   }
}
