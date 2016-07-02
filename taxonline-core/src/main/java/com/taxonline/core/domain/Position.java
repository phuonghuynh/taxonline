package com.taxonline.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
      value = { @NamedQuery(
            name = "Position.findByNameVnLikeAndNameEnLike",
            query = "SELECT n FROM Position n WHERE LOWER(n.nameVn) LIKE '%'||LOWER(:nameVn)||'%' AND LOWER(n.nameEn) LIKE '%'||LOWER(:nameEn)||'%'") })
public class Position extends AbstractIdEntity {

   private static final long serialVersionUID = 5302108960463247066L;

   @Column(name = "name_vn")
   private String nameVn;

   @Column(name = "name_en")
   private String nameEn;

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

}
