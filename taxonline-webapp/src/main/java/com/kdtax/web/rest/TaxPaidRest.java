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

import com.taxonline.core.domain.TaxPaid;
import com.taxonline.core.dto.TaxPaidDto;
import com.taxonline.core.metadata.request.EmpyearMetadata;
import com.taxonline.core.repo.CurrencyEntityRepo;
import com.taxonline.core.repo.TaxPaidRepo;
import com.taxonline.core.service.TaxonlineManager;

@Controller
@RequestMapping("taxpaid")
public class TaxPaidRest extends AbstractCrudRest<TaxPaid, TaxPaidDto> {

   @Resource
   private TaxPaidRepo taxPaidRepo;

   @Resource
   private TaxonlineManager taxonlineManager;

   @Resource
   private CurrencyEntityRepo currencyEntityRepo;

   @SuppressWarnings("unchecked")
   @ResponseBody
   @RequestMapping(value = "g", method = { RequestMethod.PUT, RequestMethod.POST })
   public Set<TaxPaidDto> createOrUpdate(@RequestBody EmpyearMetadata metadata) {
      Set<TaxPaid> set = (Set<TaxPaid>) taxonlineManager.generateCurrency(TaxPaid.class, metadata);
      return map2Dto(set);
   }

   @SuppressWarnings("unchecked")
   @ResponseBody
   @RequestMapping(value = "f", method = { RequestMethod.GET })
   public Set<TaxPaidDto> findByPeriod(@RequestParam("employeeId") Long employeeId, @RequestParam("year") Integer year) {
      List<TaxPaid> list = (List<TaxPaid>) currencyEntityRepo
            .findInPeriod(TaxPaid.class, 1, 12, year, employeeId, null);
      return map2Dto(list);
   }

   public JpaRepository<TaxPaid, Long> getRepo() {
      return taxPaidRepo;
   }

}
