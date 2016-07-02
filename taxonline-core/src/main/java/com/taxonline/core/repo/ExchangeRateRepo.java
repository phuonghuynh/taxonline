package com.taxonline.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxonline.core.domain.ExchangeRate;

public interface ExchangeRateRepo extends JpaRepository<ExchangeRate, Long> {

   List<ExchangeRate> findByYear(Integer year);
}
