package com.springbatch.spring_batch_mastery_001.repository;

import com.springbatch.spring_batch_mastery_001.entity.MerchantOnBoardingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MerchantOnBoardingRepository extends JpaRepository<MerchantOnBoardingEntity, Long> {

    MerchantOnBoardingEntity findByCardPresentOrganisationID(String cp);
}
