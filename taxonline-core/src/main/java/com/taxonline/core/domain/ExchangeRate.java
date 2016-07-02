package com.taxonline.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "exchange_rate")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class ExchangeRate extends AbstractCurrencyEntity {

   private static final long serialVersionUID = -1408200724609385186L;

   @Column
   private Double rate;

   public ExchangeRate() {
   }

   public ExchangeRate(int month, int year, CyCurrency currency) {
      super(month, year);
      this.currency = currency;
   }

   public Double getRate() {
      return rate;
   }

   public void setRate(Double rate) {
      this.rate = rate;
   }

}
