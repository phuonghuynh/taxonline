package com.kdtax.web.rest;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxonline.core.domain.HeadOfOffice;
import com.taxonline.core.dto.HeadOfOfficeDto;
import com.taxonline.core.repo.HeadOfOfficeRepo;

@Controller
@RequestMapping("hoo")
public class HeadOfOfficeRest extends AbstractCrudRest<HeadOfOffice, HeadOfOfficeDto> {

   @Resource
   private HeadOfOfficeRepo headOfOfficeRepo;

   public JpaRepository<HeadOfOffice, Long> getRepo() {
      return headOfOfficeRepo;
   }

}
