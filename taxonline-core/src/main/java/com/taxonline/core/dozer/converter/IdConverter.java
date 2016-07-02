package com.taxonline.core.dozer.converter;

import org.dozer.CustomConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.taxonline.core.domain.AbstractIdEntity;

public class IdConverter implements CustomConverter {

   private JpaRepository<AbstractIdEntity, Long> repo;

   public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
      if (source instanceof Long) {
         return repo.findOne((Long) source);
      }
      else if (source instanceof AbstractIdEntity) {
         return ((AbstractIdEntity)source).getId();
      }
      return null;
   }

   public void setRepo(JpaRepository<AbstractIdEntity, Long> repo) {
      this.repo = repo;
   }
}
