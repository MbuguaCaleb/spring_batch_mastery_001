package com.springbatch.spring_batch_mastery_001.batch;

import com.springbatch.spring_batch_mastery_001.entity.BookEntity;
import com.springbatch.spring_batch_mastery_001.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BookWriter implements ItemWriter<BookEntity> {

    @Autowired
    private  BookRepository bookRepository;

    @Override
    public void write(Chunk <? extends BookEntity> chunk) throws Exception {
        log.info("Writing: {} ", chunk.getItems().size());
        bookRepository.saveAll(chunk.getItems());
    }
}
