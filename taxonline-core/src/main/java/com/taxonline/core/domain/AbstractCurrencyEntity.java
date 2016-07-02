package com.taxonline.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "abstract_currency")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractCurrencyEntity extends AbstractIdEntity {

   private static final long serialVersionUID = -4088276257163911853L;

   public static enum CyCurrency {
      USD, VND, AUD, SGD, JPY, RUB, EUR, XOF
   };

   @Column(name = "cy_month")
   protected Integer month;

   @Column(name = "cy_year")
   protected Integer year;

   @Enumerated(EnumType.STRING)
   @Column(name = "cy_currency")
   protected CyCurrency currency;

   public AbstractCurrencyEntity() {
      this.currency = CyCurrency.VND;
   }

   public AbstractCurrencyEntity(int month, int year) {
      this();
      this.month = month;
      this.year = year;
   }

   public AbstractCurrencyEntity(int month, int year, CyCurrency currency) {
      this(month, year);
      this.currency = currency;
   }

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
