package com.taxonline.core.repo.support;

import com.taxonline.core.domain.AbstractCurrencyEntity;
import com.taxonline.core.metadata.CurrencyMetadata;

public interface CurrencyEntityReposupport<T extends AbstractCurrencyEntity> {

   /* 
    * @important
    * - used to determine bean-by-name
    * - implementation class name should follow pattern: {concrete-entity-name}{IMPLSUFFIX}
    * 
    * @example [class TaxPaidCurrencyReposupport] is combined between 
    * - "TaxPaid" (concrete-entity-name)
    * - "CurrencyReposupport" (implementation suffix)
    */
   final static String IMPLSUFFIX = "CurrencyReposupport";

   T newEntity(CurrencyMetadata currencyMetadata);

   T save(T entity);
}
