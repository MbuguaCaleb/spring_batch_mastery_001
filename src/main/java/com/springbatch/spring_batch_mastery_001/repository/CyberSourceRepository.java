package com.springbatch.spring_batch_mastery_001.repository;

import com.springbatch.spring_batch_mastery_001.entity.BatchDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CyberSourceRepository extends JpaRepository<BatchDetailsEntity,Long> {
}
