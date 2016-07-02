package com.taxonline.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

public class Hibernate4AwareObjectMapper extends ObjectMapper {

   private static final long serialVersionUID = 1804380357522525763L;

   public Hibernate4AwareObjectMapper() {
      Hibernate4Module hm = new Hibernate4Module();
      hm.enable(Feature.FORCE_LAZY_LOADING);
      registerModule(hm);
   }
}
