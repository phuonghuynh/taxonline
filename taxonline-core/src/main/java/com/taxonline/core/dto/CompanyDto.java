package com.taxonline.core.dto;

import com.taxonline.core.domain.AbstractIdEntity;

public class CompanyDto extends AbstractIdEntity {

   private static final long serialVersionUID = 586191403940294202L;

   private String nameVn;

   private String nameEn;

   private String address;

   private Long headOfOfficeId;

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

   public Long getHeadOfOfficeId() {
      return headOfOfficeId;
   }

   public void setHeadOfOfficeId(Long headOfOfficeId) {
      this.headOfOfficeId = headOfOfficeId;
   }

}
