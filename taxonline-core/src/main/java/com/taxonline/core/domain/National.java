package com.taxonline.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
      value = { @NamedQuery(
            name = "National.findByNameVnLikeAndNameEnLike",
            query = "SELECT n FROM National n WHERE LOWER(n.nameVn) LIKE '%'||LOWER(:nameVn)||'%' AND LOWER(n.nameEn) LIKE '%'||LOWER(:nameEn)||'%'") })
public class National extends AbstractIdEntity {

   private static final long serialVersionUID = 5110281624174404128L;

   @Column(name = "name_vn")
   private String nameVn;

   @Column(name = "name_en")
   private String nameEn;

   // @OneToMany(mappedBy = "national")
   // private Set<HeadOfOffice> headOfOffices = new HashSet<HeadOfOffice>();

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

   // public Set<HeadOfOffice> getHeadOfOffices() {
   // return headOfOffices;
   // }
   //
   // public void setHeadOfOffices(Set<HeadOfOffice> headOfOffices) {
   // this.headOfOffices = headOfOffices;
   // }
}
