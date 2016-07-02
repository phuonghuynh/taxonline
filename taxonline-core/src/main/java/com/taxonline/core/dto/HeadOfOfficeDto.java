package com.taxonline.core.dto;

import com.taxonline.core.domain.AbstractIdEntity;

public class HeadOfOfficeDto extends AbstractIdEntity {

   private static final long serialVersionUID = 8210215917949476703L;

   private String nameEn;

   private String address;

   private Long nationalId;

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

   public Long getNationalId() {
      return nationalId;
   }

   public void setNationalId(Long nationalId) {
      this.nationalId = nationalId;
   }

}
