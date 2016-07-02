package com.taxonline.core.service;

import java.util.Set;

import com.taxonline.core.domain.AbstractCurrencyEntity;
import com.taxonline.core.domain.National;
import com.taxonline.core.domain.Position;
import com.taxonline.core.metadata.AbstractMetadata;

public interface TaxonlineManager {

   Set<Position> findPositionByDomain(Position position);

   Set<National> findNationalByDomain(National national);

   Set<? extends AbstractCurrencyEntity> generateCurrency(Class<? extends AbstractCurrencyEntity> clazz,
         AbstractMetadata metadata);

}
