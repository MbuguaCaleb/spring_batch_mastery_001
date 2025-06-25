package com.springbatch.spring_batch_mastery_001.repository;

import com.springbatch.spring_batch_mastery_001.entity.MerchantCategoryCodesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantCategoryCodesRepository extends JpaRepository<MerchantCategoryCodesEntity, Long> {
    Optional<MerchantCategoryCodesEntity> findByMerchantCategoryCode(String merchantCategoryCode);

}
