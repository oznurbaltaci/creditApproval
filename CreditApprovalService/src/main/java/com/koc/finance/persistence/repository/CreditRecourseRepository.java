package com.koc.finance.persistence.repository;

import com.koc.finance.persistence.entity.CreditRecourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditRecourseRepository extends JpaRepository<CreditRecourseEntity, Long> {
    Optional<CreditRecourseEntity> findByIdentityNumber(Long identityNumber);
}
