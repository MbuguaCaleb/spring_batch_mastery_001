package com.springbatch.spring_batch_mastery_001.repository;

import com.springbatch.spring_batch_mastery_001.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
