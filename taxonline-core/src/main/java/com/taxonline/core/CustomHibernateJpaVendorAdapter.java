package com.taxonline.core;

import java.util.Map;

import org.hibernate.cfg.Environment;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class CustomHibernateJpaVendorAdapter extends HibernateJpaVendorAdapter {

   private boolean formatSql = false;

   public Map<String, Object> getJpaPropertyMap() {
      Map<String, Object> jpaProperties = super.getJpaPropertyMap();
      if (formatSql) {
         jpaProperties.put(Environment.FORMAT_SQL, "true");
      }
      return jpaProperties;
   }

   public void setFormatSql(boolean formatSql) {
      this.formatSql = formatSql;
   }
}
