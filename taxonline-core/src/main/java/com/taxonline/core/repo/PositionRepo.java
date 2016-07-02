package com.taxonline.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.taxonline.core.domain.Position;

public interface PositionRepo extends JpaRepository<Position, Long> {

   List<Position> findByNameVnLikeAndNameEnLike(@Param("nameVn") String nameVn, @Param("nameEn") String nameEn);

   Position findByNameVnAndNameEn(String nameVn, String nameEn);

}
