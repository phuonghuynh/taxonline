package com.kdtax.web.rest;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxonline.core.domain.National;
import com.taxonline.core.repo.NationalRepo;

@Controller
@RequestMapping("national")
public class NationalRest extends AbstractCrudRest<National, National> {

   @Resource
   private NationalRepo nationalRepo;

   public JpaRepository<National, Long> getRepo() {
      return nationalRepo;
   }

}
