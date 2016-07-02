package com.taxonline.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxonline.core.domain.TaxPaid;

public interface TaxPaidRepo extends JpaRepository<TaxPaid, Long> {

}
