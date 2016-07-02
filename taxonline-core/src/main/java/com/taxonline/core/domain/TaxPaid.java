package com.taxonline.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tax_paid")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class TaxPaid extends AbstractCurrencyEntity {

   private static final long serialVersionUID = -8856844810134127364L;

   @Column
   private Double amount;

   @Column
   private String reference;

   @ManyToOne
   @JoinColumn(name = "employee_id", referencedColumnName = "id")
   private Employee employee;

   public TaxPaid() {
   }

   public TaxPaid(int month, int year, Employee employee) {
      super(month, year, CyCurrency.VND);
      this.employee = employee;
   }

   public Employee getEmployee() {
      return employee;
   }

   public void setEmployee(Employee employee) {
      this.employee = employee;
   }

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
}
