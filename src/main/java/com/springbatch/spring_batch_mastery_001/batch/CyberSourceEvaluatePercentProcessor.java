package com.springbatch.spring_batch_mastery_001.batch;

import com.springbatch.spring_batch_mastery_001.entity.BatchDetailsEntity;
import com.springbatch.spring_batch_mastery_001.repository.MerchantCategoryCodesRepository;
import com.springbatch.spring_batch_mastery_001.repository.MerchantOnBoardingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CyberSourceEvaluatePercentProcessor implements ItemProcessor<BatchDetailsEntity, BatchDetailsEntity> {

    @Autowired
    private MerchantCategoryCodesRepository merchantCategoryCodesRepository;

    @Autowired
    private MerchantOnBoardingRepository merchantOnBoardingRepository;


    @Override
    public BatchDetailsEntity process(BatchDetailsEntity item) throws Exception {


        log.info("Process author: {}", item);
       item.setPercentage("1.5");
       return item;
    }
}
