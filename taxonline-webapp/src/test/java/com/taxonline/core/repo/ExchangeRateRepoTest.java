package com.taxonline.core.repo;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.taxonline.core.domain.AbstractCurrencyEntity.CyCurrency;
import com.taxonline.core.domain.ExchangeRate;

@DataSet(dtdMetadata = true, locations = "sample-data.xml")
public class ExchangeRateRepoTest extends AbstractRepoUnitTest {

   @Resource
   private ExchangeRateRepo exchangeRateRepo;

   @Test
   public void testCreateNew() {
//      ExchangeRate rate = exchangeRateRepo.findByMonthAndYear(10, 2012, CyCurrency.AUS);
//      if (rate == null) {
//         rate = new ExchangeRate(10, 2012, CyCurrency.AUS);
//         exchangeRateRepo.saveAndFlush(rate);
//      }
   }

   @Test
   public void testFindOne() {
//      testCreateNew();
//      ExchangeRate rate = exchangeRateRepo.findByMonthAndYear(10, 2012, CyCurrency.VND);
//      Assert.assertEquals(rate, null);
//
//      rate = exchangeRateRepo.findByMonthAndYear(10, 2012, CyCurrency.AUS);
//      Assert.assertFalse(rate == null);
   }
}
