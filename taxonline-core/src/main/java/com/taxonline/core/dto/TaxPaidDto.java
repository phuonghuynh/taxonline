package com.taxonline.core.dto;

import com.taxonline.core.domain.AbstractCurrencyEntity.CyCurrency;
import com.taxonline.core.domain.AbstractIdEntity;

public class TaxPaidDto extends AbstractIdEntity {

   private static final long serialVersionUID = -8704703358338204008L;

   private Integer month;

   private Integer year;

   private CyCurrency currency;

   private Double amount;

   private String reference;

   private Long employeeId;

   public Double getAmount() {
      return amount;
   }

   public void setAmount(Double amount) {
      this.amount = amount;
   }

   public String getReference() {
      return reference;
   }

   public void setReference(String reference) {
      this.reference = reference;
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

   public Long getEmployeeId() {
      return employeeId;
   }

   public void setEmployeeId(Long employeeId) {
      this.employeeId = employeeId;
   }
}
