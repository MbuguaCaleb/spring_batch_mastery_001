package com.springbatch.spring_batch_mastery_001.batch;

import com.springbatch.spring_batch_mastery_001.entity.BatchDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class CyberSourceProcessor implements ItemProcessor<BatchDetailsEntity, BatchDetailsEntity> {

    @Override
    public BatchDetailsEntity process(BatchDetailsEntity item) throws Exception {
       log.info("Process author: {}", item);
       item.setPercentage("1.5");
       return item;
    }
}
