package com.taxonline.core.factory;

import com.taxonline.core.domain.AbstractCurrencyEntity.CyCurrency;
import com.taxonline.core.domain.AbstractIdEntity;
import com.taxonline.core.domain.CompulsoryContribution;
import com.taxonline.core.domain.Employee;
import com.taxonline.core.domain.ExchangeRate;
import com.taxonline.core.domain.National;
import com.taxonline.core.domain.Position;
import com.taxonline.core.domain.TaxPaid;

public final class EntityFactory {

   public static void nullToEmpty(Position position) {
      if (position.getNameEn() == null) {
         position.setNameEn("");
      }
      if (position.getNameVn() == null) {
         position.setNameVn("");
      }
   }

   public static void nullToEmpty(National national) {
      if (national.getNameEn() == null) {
         national.setNameEn("");
      }
      if (national.getNameVn() == null) {
         national.setNameVn("");
      }
   }

   public static Long getId(AbstractIdEntity entity) {
      if (entity != null) {
         return entity.getId();
      }
      return null;
   }

   public static TaxPaid newTaxPaid(int month, int year, Employee employee) {
      return new TaxPaid(month, year, employee);
   }

   public static ExchangeRate newExchangeRate(int month, int year, CyCurrency currency) {
      return new ExchangeRate(month, year, currency);
   }

   public static CompulsoryContribution newCompulsoryContribution(int month, int year, Employee employee) {
      return new CompulsoryContribution(month, year, employee);
   }
}
