package com.taxonline.core.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.taxonline.core.domain.AbstractCurrencyEntity;
import com.taxonline.core.domain.National;
import com.taxonline.core.domain.Position;
import com.taxonline.core.factory.EntityFactory;
import com.taxonline.core.metadata.AbstractMetadata;
import com.taxonline.core.metadata.CurrencyMetadata;
import com.taxonline.core.repo.CurrencyEntityRepo;
import com.taxonline.core.repo.NationalRepo;
import com.taxonline.core.repo.PositionRepo;
import com.taxonline.core.repo.support.CurrencyEntityReposupport;
import com.taxonline.core.service.TaxonlineManager;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TaxonlineManagerV2013 implements TaxonlineManager {

   private static final Log LOG = LogFactory.getLog(TaxonlineManagerV2013.class);

   @Resource
   private NationalRepo nationalRepo;

   @Resource
   private PositionRepo positionRepo;

   @Resource
   private CurrencyEntityRepo currencyEntityRepo;

   @Resource
   private ApplicationContext applicationContext;

   @Resource
   protected Mapper mapper;

   public Set<Position> findPositionByDomain(Position position) {
      EntityFactory.nullToEmpty(position);
      Set<Position> positions = new HashSet<Position>(positionRepo.findByNameVnLikeAndNameEnLike(position.getNameVn(),
            position.getNameEn()));
      LOG.debug("Found " + positions.size() + " Position(s).");
      return positions;
   }

   public Set<National> findNationalByDomain(National national) {
      EntityFactory.nullToEmpty(national);
      Set<National> nationals = new HashSet<National>(nationalRepo.findByNameVnLikeAndNameEnLike(national.getNameVn(),
            national.getNameEn()));
      LOG.debug("Found " + nationals.size() + " Position(s).");
      return nationals;
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   public Set<? extends AbstractCurrencyEntity> generateCurrency(Class<? extends AbstractCurrencyEntity> clazz,
         AbstractMetadata metadata) {
      String supportBeanName = StringUtils.uncapitalize(clazz.getSimpleName()) + CurrencyEntityReposupport.IMPLSUFFIX;
      CurrencyEntityReposupport currencyRepoSupport = applicationContext.getBean(supportBeanName,
            CurrencyEntityReposupport.class);
      Set<AbstractCurrencyEntity> currencies = new HashSet<AbstractCurrencyEntity>();
      for (int month = 1; month <= 12; month++) {
         CurrencyMetadata currencyMetadata = mapper.map(metadata, CurrencyMetadata.class);
         currencyMetadata.setMonth(month);
         AbstractCurrencyEntity currency = currencyEntityRepo.findByMonthAndYear(clazz, currencyMetadata);
         if (currency == null) {
            currency = currencyRepoSupport.newEntity(currencyMetadata);
         }
         currencies.add(currencyRepoSupport.save(currency));
      }
      return currencies;
   }

}
