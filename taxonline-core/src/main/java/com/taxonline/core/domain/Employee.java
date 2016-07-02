package com.taxonline.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee extends AbstractIdEntity {

   private static final long serialVersionUID = 8557860932788538567L;

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column
   private String taxcode;

   @Column
   @Temporal(TemporalType.DATE)
   private Date dob;

   @Column(name = "number_of_dependant")
   private Integer nod;

   @Column(name = "passport_no")
   private String pwdno;

   @Column(name = "arrival_date")
   @Temporal(TemporalType.DATE)
   private Date arrivalDate;

   @Column(name = "termination_date")
   @Temporal(TemporalType.DATE)
   private Date terminationDate;

   @ManyToOne
   @JoinColumn(name = "national_id", referencedColumnName = "id")
   private National national;

   @ManyToOne
   @JoinColumn(name = "compulsory_insurance_id", referencedColumnName = "id")
   private National compulsoryInsuranceNational;

   @ManyToOne
   @JoinColumn(name = "position_id", referencedColumnName = "id")
   private Position position;

   @ManyToOne
   @JoinColumn(name = "company_id", referencedColumnName = "id")
   private Company company;

//   @Column(name = "tax_from")
//   private Integer taxFrom;
//
//   @Column(name = "tax_to")
//   private Integer taxTo;

//   @Column(name = "tax_year")
//   private Integer taxYear;

   @ManyToOne
   @JoinColumn(name = "tax_office_id", referencedColumnName = "id")
   private National taxOffice;

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getTaxcode() {
      return taxcode;
   }

   public void setTaxcode(String taxcode) {
      this.taxcode = taxcode;
   }

   public Date getDob() {
      return dob;
   }

   public void setDob(Date dob) {
      this.dob = dob;
   }

   public Integer getNod() {
      return nod;
   }

   public void setNod(Integer nod) {
      this.nod = nod;
   }

   public String getPwdno() {
      return pwdno;
   }

   public void setPwdno(String pwdno) {
      this.pwdno = pwdno;
   }

   public Date getArrivalDate() {
      return arrivalDate;
   }

   public void setArrivalDate(Date arrivalDate) {
      this.arrivalDate = arrivalDate;
   }

   public Date getTerminationDate() {
      return terminationDate;
   }

   public void setTerminationDate(Date terminationDate) {
      this.terminationDate = terminationDate;
   }

   public National getNational() {
      return national;
   }

   public void setNational(National national) {
      this.national = national;
   }

   public National getCompulsoryInsuranceNational() {
      return compulsoryInsuranceNational;
   }

   public void setCompulsoryInsuranceNational(National compulsoryInsuranceNational) {
      this.compulsoryInsuranceNational = compulsoryInsuranceNational;
   }

   public Position getPosition() {
      return position;
   }

   public void setPosition(Position position) {
      this.position = position;
   }

   public Company getCompany() {
      return company;
   }

   public void setCompany(Company company) {
      this.company = company;
   }

   public National getTaxOffice() {
      return taxOffice;
   }

   public void setTaxOffice(National taxOffice) {
      this.taxOffice = taxOffice;
   }
}
