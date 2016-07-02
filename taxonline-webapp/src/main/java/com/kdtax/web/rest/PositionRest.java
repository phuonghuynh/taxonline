package com.kdtax.web.rest;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxonline.core.domain.Position;
import com.taxonline.core.repo.PositionRepo;

@Controller
@RequestMapping("position")
public class PositionRest extends AbstractCrudRest<Position, Position> {

   @Resource
   private PositionRepo positionRepo;

   public JpaRepository<Position, Long> getRepo() {
      return positionRepo;
   }

}
