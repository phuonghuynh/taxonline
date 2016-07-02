package com.taxonline.core.metadata.request;

import com.taxonline.core.domain.AbstractCurrencyEntity.CyCurrency;
import com.taxonline.core.metadata.AbstractMetadata;

public class ExchangeRateMetadata extends AbstractMetadata {

   private static final long serialVersionUID = 8545862086290616789L;

   private int year;

   private CyCurrency currency;

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public CyCurrency getCurrency() {
      return currency;
   }

   public void setCurrency(CyCurrency currency) {
      this.currency = currency;
   }

}
