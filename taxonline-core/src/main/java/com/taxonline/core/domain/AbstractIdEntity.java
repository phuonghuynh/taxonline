package com.taxonline.core.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property="@id")
public abstract class AbstractIdEntity implements Serializable {

   private static final long serialVersionUID = 2411023541609044816L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      AbstractIdEntity other = (AbstractIdEntity) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      }
      else if (!id.equals(other.id))
         return false;
      return true;
   }

   public String toString() {
      return getClass().getSimpleName() + "[id=" + id + "]";
   }
}
