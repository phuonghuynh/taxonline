package com.taxonline.core.exception;

public class DuplicatedEntityException extends Exception {

   private static final long serialVersionUID = -5911451544019261024L;

   public DuplicatedEntityException(String error) {
      super(error);
   }
}
