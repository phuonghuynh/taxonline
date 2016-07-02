package com.kdtax.web.rest;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxonline.core.domain.ExchangeRate;
import com.taxonline.core.metadata.request.ExchangeRateMetadata;
import com.taxonline.core.repo.CurrencyEntityRepo;
import com.taxonline.core.repo.ExchangeRateRepo;
import com.taxonline.core.service.TaxonlineManager;

@Controller
@RequestMapping("exrate")
public class ExchangeRateRest extends AbstractCrudRest<ExchangeRate, ExchangeRate> {

   @Resource
   private ExchangeRateRepo exchangeRateRepo;

   @Resource
   private TaxonlineManager taxonlineManager;

   @Resource
   private CurrencyEntityRepo currencyEntityRepo;

   @SuppressWarnings("unchecked")
   @ResponseBody
   @RequestMapping(value = "g", method = { RequestMethod.PUT, RequestMethod.POST })
   public Set<ExchangeRate> createOrUpdate(@RequestBody ExchangeRateMetadata metadata) {
      Set<ExchangeRate> set = (Set<ExchangeRate>) taxonlineManager.generateCurrency(ExchangeRate.class, metadata);
      return map2Dto(set);
   }

   @SuppressWarnings("unchecked")
   @ResponseBody
   @RequestMapping(value = "f", method = { RequestMethod.GET })
   public Set<ExchangeRate> findByYear(@RequestParam("year") Integer year) {
      List<ExchangeRate> list = (List<ExchangeRate>) currencyEntityRepo.findInPeriod(ExchangeRate.class, 1, 12, year,
            null, null);
      return map2Dto(list);
   }

   public JpaRepository<ExchangeRate, Long> getRepo() {
      return exchangeRateRepo;
   }

}
