package com.taxonline.core.metadata.request;

import com.taxonline.core.metadata.AbstractMetadata;

public class EmpyearMetadata extends AbstractMetadata {

   private static final long serialVersionUID = 3897998652888553483L;

   private int year;

   private long employeeId;

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public long getEmployeeId() {
      return employeeId;
   }

   public void setEmployeeId(long employeeId) {
      this.employeeId = employeeId;
   }

}
