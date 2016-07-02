package com.taxonline.core.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taxonline.core.domain.AbstractCurrencyEntity;
import com.taxonline.core.domain.AbstractCurrencyEntity.CyCurrency;
import com.taxonline.core.metadata.CurrencyMetadata;
import com.taxonline.core.repo.CurrencyEntityRepo;

@Repository
public class CurrencyEntityRepoImpl implements CurrencyEntityRepo {

   private static final Log LOG = LogFactory.getLog(CurrencyEntityRepoImpl.class);

   @PersistenceContext
   private EntityManager entityManager;

   public AbstractCurrencyEntity findByMonthAndYear(Class<? extends AbstractCurrencyEntity> clazz,
         CurrencyMetadata currencyMetadata) {
      // "Select e From " + clazz.getSimpleName() +
      //    " e Where e.month=:month and e.year=:year and e.employee.id=:employeeId";
      StringBuilder sqlBuilder = new StringBuilder(" Select e From ");
      sqlBuilder.append(clazz.getSimpleName()).append(" e Where e.month=:month and e.year=:year ");

      Long employeeId = currencyMetadata.getEmployeeId();
      CyCurrency currency = currencyMetadata.getCurrency();
      appendWhere(sqlBuilder, employeeId, currency);

      Query query = entityManager.createQuery(sqlBuilder.toString());
      query.setParameter("month", currencyMetadata.getMonth());
      query.setParameter("year", currencyMetadata.getYear());
      if (employeeId != null) {
         query.setParameter("employeeId", employeeId);
      }
      if (currency != null) {
         query.setParameter("currency", currency);
      }

      try {
         return (AbstractCurrencyEntity) query.getSingleResult();
      }
      catch (Exception e) {
         LOG.debug("No entity found", e);
      }
      return null;
   }

   @SuppressWarnings("unchecked")
   public List<? extends AbstractCurrencyEntity> findInPeriod(Class<? extends AbstractCurrencyEntity> clazz,
         Integer from, Integer to, Integer year, Long employeeId, CyCurrency currency) {
      StringBuilder sqlBuilder = new StringBuilder(" Select e From ");
      sqlBuilder.append(clazz.getSimpleName()).append(" e Where e.month>=:from and e.month<=:to and e.year=:year ");
      appendWhere(sqlBuilder, employeeId, currency);

      Query query = entityManager.createQuery(sqlBuilder.toString());
      query.setParameter("from", from);
      query.setParameter("to", to);
      query.setParameter("year", year);
      if (employeeId != null) {
         query.setParameter("employeeId", employeeId);
      }
      if (currency != null) {
         query.setParameter("currency", currency);
      }

      try {
         return query.getResultList();
      }
      catch (Exception e) {
         LOG.error("No entity found", e);
      }
      return null;
   }

   private void appendWhere(StringBuilder sqlBuilder, Long employeeId, CyCurrency currency) {
      if (employeeId != null) {
         sqlBuilder.append(" and e.employee.id=:employeeId ");
      }
      if (currency != null) {
         sqlBuilder.append(" and e.currency=:currency ");
      }
   }

}
