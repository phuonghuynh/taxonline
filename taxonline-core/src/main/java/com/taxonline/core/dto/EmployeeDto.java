package com.taxonline.core.dto;

import java.util.Date;

import com.taxonline.core.domain.AbstractIdEntity;

public class EmployeeDto extends AbstractIdEntity {

   private static final long serialVersionUID = 1L;

   private String firstName;

   private String lastName;

   private String taxcode;

   private Date dob;

   private Integer nod;

   private String pwdno;

   private Date arrivalDate;

   private Date terminationDate;

   private Long nationalId;

   private Long compulsoryInsuranceNationalId;

   private Long positionId;

   private Long companyId;

//   private Integer taxFrom;
//
//   private Integer taxTo;
//
//   private Integer taxYear;

   private Long taxOfficeId;

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

   public Long getNationalId() {
      return nationalId;
   }

   public void setNationalId(Long nationalId) {
      this.nationalId = nationalId;
   }

   public Long getCompulsoryInsuranceNationalId() {
      return compulsoryInsuranceNationalId;
   }

   public void setCompulsoryInsuranceNationalId(Long compulsoryInsuranceNationalId) {
      this.compulsoryInsuranceNationalId = compulsoryInsuranceNationalId;
   }

   public Long getPositionId() {
      return positionId;
   }

   public void setPositionId(Long positionId) {
      this.positionId = positionId;
   }

   public Long getCompanyId() {
      return companyId;
   }

   public void setCompanyId(Long companyId) {
      this.companyId = companyId;
   }

//   public Integer getTaxFrom() {
//      return taxFrom;
//   }
//
//   public void setTaxFrom(Integer taxFrom) {
//      this.taxFrom = taxFrom;
//   }
//
//   public Integer getTaxTo() {
//      return taxTo;
//   }
//
//   public void setTaxTo(Integer taxTo) {
//      this.taxTo = taxTo;
//   }
//
//   public Integer getTaxYear() {
//      return taxYear;
//   }
//
//   public void setTaxYear(Integer taxYear) {
//      this.taxYear = taxYear;
//   }

   public Long getTaxOfficeId() {
      return taxOfficeId;
   }

   public void setTaxOfficeId(Long taxOfficeId) {
      this.taxOfficeId = taxOfficeId;
   }
}
