package com.taxonline.core.repo.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.taxonline.core.domain.ExchangeRate;
import com.taxonline.core.factory.EntityFactory;
import com.taxonline.core.metadata.CurrencyMetadata;
import com.taxonline.core.repo.ExchangeRateRepo;
import com.taxonline.core.repo.support.CurrencyEntityReposupport;

@Component
public class ExchangeRateCurrencyReposupport implements CurrencyEntityReposupport<ExchangeRate> {

   @Resource
   private ExchangeRateRepo exchangeRateRepo;

   public ExchangeRate newEntity(CurrencyMetadata currencyMetadata) {
      return EntityFactory.newExchangeRate(currencyMetadata.getMonth(), currencyMetadata.getYear(),
            currencyMetadata.getCurrency());
   }

   public ExchangeRate save(ExchangeRate entity) {
      return exchangeRateRepo.save(entity);
   }

}
