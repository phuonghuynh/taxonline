package com.taxonline.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Company extends AbstractIdEntity {

   private static final long serialVersionUID = -8174763951369696686L;

   @Column(name = "name_vn")
   private String nameVn;

   @Column(name = "name_en")
   private String nameEn;

   @Column
   private String address;

   @ManyToOne
   @JoinColumn(name = "hoo_id", referencedColumnName = "id")
   private HeadOfOffice headOfOffice;

   public String getNameVn() {
      return nameVn;
   }

   public void setNameVn(String nameVn) {
      this.nameVn = nameVn;
   }

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

   public HeadOfOffice getHeadOfOffice() {
      return headOfOffice;
   }

   public void setHeadOfOffice(HeadOfOffice headOfOffice) {
      this.headOfOffice = headOfOffice;
   }
}
