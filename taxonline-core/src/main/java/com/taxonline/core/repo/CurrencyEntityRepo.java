package com.taxonline.core.repo;

import java.util.List;

import com.taxonline.core.domain.AbstractCurrencyEntity;
import com.taxonline.core.domain.AbstractCurrencyEntity.CyCurrency;
import com.taxonline.core.metadata.CurrencyMetadata;

public interface CurrencyEntityRepo {

   AbstractCurrencyEntity findByMonthAndYear(Class<? extends AbstractCurrencyEntity> clazz,
         CurrencyMetadata currencyMetadata);

   List<? extends AbstractCurrencyEntity> findInPeriod(Class<? extends AbstractCurrencyEntity> clazz, Integer to,
         Integer from, Integer year, Long employeeId, CyCurrency currency);
}
