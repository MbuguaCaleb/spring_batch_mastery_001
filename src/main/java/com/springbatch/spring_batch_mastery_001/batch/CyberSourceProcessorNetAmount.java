package com.springbatch.spring_batch_mastery_001.batch;

import com.springbatch.spring_batch_mastery_001.entity.BatchDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class CyberSourceProcessorNetAmount implements ItemProcessor<BatchDetailsEntity, BatchDetailsEntity> {

    @Override
    public BatchDetailsEntity process(BatchDetailsEntity item) throws Exception {
       log.info("Process author: {}", item);
       item.setNetAmount("1500");
       return item;
    }
}
