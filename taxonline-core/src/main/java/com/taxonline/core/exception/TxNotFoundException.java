package com.taxonline.core.exception;

public class TxNotFoundException extends Exception {

   private static final long serialVersionUID = 8594736877995334559L;

   public TxNotFoundException(String error) {
      super(error);
   }
}
