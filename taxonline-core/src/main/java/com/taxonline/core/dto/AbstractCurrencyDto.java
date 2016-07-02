package com.taxonline.core.dto;

import com.taxonline.core.domain.AbstractCurrencyEntity.CyCurrency;
import com.taxonline.core.domain.AbstractIdEntity;

public abstract class AbstractCurrencyDto extends AbstractIdEntity {

   private static final long serialVersionUID = 1801304195650620384L;

   protected Integer month;

   protected Integer year;

   protected CyCurrency currency;

   public Integer getMonth() {
      return month;
   }

   public void setMonth(Integer month) {
      this.month = month;
   }

   public Integer getYear() {
      return year;
   }

   public void setYear(Integer year) {
      this.year = year;
   }

   public CyCurrency getCurrency() {
      return currency;
   }

   public void setCurrency(CyCurrency currency) {
      this.currency = currency;
   }

}
