package com.taxonline.core.metadata;

import java.io.Serializable;

import com.taxonline.core.domain.AbstractCurrencyEntity.CyCurrency;

public class CurrencyMetadata implements Serializable {

   private static final long serialVersionUID = 2308090897743144890L;

   private Integer year;

   private Long employeeId;

   private CyCurrency currency;

   private Integer month;

   public Integer getYear() {
      return year;
   }

   public void setYear(Integer year) {
      this.year = year;
   }

   public Long getEmployeeId() {
      return employeeId;
   }

   public void setEmployeeId(Long employeeId) {
      this.employeeId = employeeId;
   }

   public CyCurrency getCurrency() {
      return currency;
   }

   public void setCurrency(CyCurrency currency) {
      this.currency = currency;
   }

   public Integer getMonth() {
      return month;
   }

   public void setMonth(Integer month) {
      this.month = month;
   }

}
