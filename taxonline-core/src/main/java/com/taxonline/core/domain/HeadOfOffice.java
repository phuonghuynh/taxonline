package com.taxonline.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "head_of_office")
public class HeadOfOffice extends AbstractIdEntity {

   private static final long serialVersionUID = 1L;

   @Column(name = "name_en")
   private String nameEn;

   @Column
   private String address;

   @ManyToOne
   @JoinColumn(name = "national_id", referencedColumnName = "id")
   private National national;

   // @OneToMany(mappedBy = "headOfOffice")
   // private Set<Company> companies = new HashSet<Company>();

   public String getNameEn() {
      return nameEn;
   }

   public void setNameEn(String nameEn) {
      this.nameEn = nameEn;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public National getNational() {
      return national;
   }

   public void setNational(National national) {
      this.national = national;
   }

   // public Set<Company> getCompanies() {
   // return companies;
   // }
   //
   // public void setCompanies(Set<Company> companies) {
   // this.companies = companies;
   // }
}
