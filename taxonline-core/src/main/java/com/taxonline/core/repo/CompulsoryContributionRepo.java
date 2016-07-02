package com.taxonline.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxonline.core.domain.CompulsoryContribution;

public interface CompulsoryContributionRepo extends JpaRepository<CompulsoryContribution, Long> {

}
