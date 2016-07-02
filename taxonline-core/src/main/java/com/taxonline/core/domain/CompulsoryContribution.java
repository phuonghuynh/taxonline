package com.taxonline.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "compulsory_contribution")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class CompulsoryContribution extends AbstractCurrencyEntity {

   private static final long serialVersionUID = 8647467057743070965L;

   @Column
   private Double amount;

   @ManyToOne
   @JoinColumn(name = "employee_id", referencedColumnName = "id")
   private Employee employee;

   public CompulsoryContribution() {
   }

   public CompulsoryContribution(int month, int year, Employee employee) {
      super(month, year);
      this.currency = CyCurrency.USD;
      this.employee = employee;
   }

   public Double getAmount() {
      return amount;
   }

   public void setAmount(Double amount) {
      this.amount = amount;
   }

   public Employee getEmployee() {
      return employee;
   }

   public void setEmployee(Employee employee) {
      this.employee = employee;
   }

}
