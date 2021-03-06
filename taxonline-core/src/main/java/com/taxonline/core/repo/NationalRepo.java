package com.taxonline.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.taxonline.core.domain.National;

public interface NationalRepo extends JpaRepository<National, Long> {

   National findByNameVnAndNameEn(String nameVn, String nameEn);

   List<National> findByNameVnLikeAndNameEnLike(@Param("nameVn") String nameVn, @Param("nameEn") String nameEn);

}
