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

import com.taxonline.core.domain.CompulsoryContribution;
import com.taxonline.core.dto.CompulsoryContributionDto;
import com.taxonline.core.metadata.request.EmpyearMetadata;
import com.taxonline.core.repo.CompulsoryContributionRepo;
import com.taxonline.core.repo.CurrencyEntityRepo;
import com.taxonline.core.service.TaxonlineManager;

@Controller
@RequestMapping(value = "compuls")
public class CompulsoryContributionRest extends AbstractCrudRest<CompulsoryContribution, CompulsoryContributionDto> {

   @Resource
   private CompulsoryContributionRepo compulsoryContributionRepo;

   @Resource
   private TaxonlineManager taxonlineManager;

   @Resource
   private CurrencyEntityRepo currencyEntityRepo;

   @SuppressWarnings("unchecked")
   @ResponseBody
   @RequestMapping(value = "g", method = { RequestMethod.PUT, RequestMethod.POST })
   public Set<CompulsoryContributionDto> createOrUpdate(@RequestBody EmpyearMetadata metadata) {
      Set<CompulsoryContribution> set = (Set<CompulsoryContribution>) taxonlineManager.generateCurrency(
            CompulsoryContribution.class, metadata);
      return map2Dto(set);
   }

   @SuppressWarnings("unchecked")
   @ResponseBody
   @RequestMapping(value = "f", method = { RequestMethod.GET })
   public Set<CompulsoryContributionDto> findByPeriod(@RequestParam("employeeId") Long employeeId,
         @RequestParam("year") Integer year) {
      List<CompulsoryContribution> list = (List<CompulsoryContribution>) currencyEntityRepo.findInPeriod(
            CompulsoryContribution.class, 1, 12, year, employeeId, null);
      return map2Dto(list);
   }

   public JpaRepository<CompulsoryContribution, Long> getRepo() {
      return compulsoryContributionRepo;
   }

}
