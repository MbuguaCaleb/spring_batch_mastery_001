package com.springbatch.spring_batch_mastery_001.batch;

import com.springbatch.spring_batch_mastery_001.entity.BatchDetailsEntity;
import com.springbatch.spring_batch_mastery_001.entity.BookEntity;
import com.springbatch.spring_batch_mastery_001.repository.BookRepository;
import com.springbatch.spring_batch_mastery_001.repository.CyberSourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CyberSourceWriter implements ItemWriter<BatchDetailsEntity> {

    @Autowired
    private CyberSourceRepository cyberSourceRepository;

    @Override
    public void write(Chunk <? extends BatchDetailsEntity> chunk) throws Exception {
        log.info("Writing: {} ", chunk.getItems().size());
        cyberSourceRepository.saveAll(chunk.getItems());
    }
}
