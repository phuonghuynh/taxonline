package com.taxonline.core.dto;

import com.taxonline.core.domain.AbstractIdEntity;

public class CompulsoryContributionDto extends AbstractIdEntity {

   private static final long serialVersionUID = -1553551688367536505L;

   private Integer month;

   private Integer year;

   private Double amount;

   private String currency;

   private Long employeeId;

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

   public Double getAmount() {
      return amount;
   }

   public void setAmount(Double amount) {
      this.amount = amount;
   }

   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   public Long getEmployeeId() {
      return employeeId;
   }

   public void setEmployeeId(Long employeeId) {
      this.employeeId = employeeId;
   }
}
