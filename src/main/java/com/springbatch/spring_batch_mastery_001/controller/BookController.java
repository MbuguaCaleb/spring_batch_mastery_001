package com.springbatch.spring_batch_mastery_001.controller;

import com.springbatch.spring_batch_mastery_001.entity.BookEntity;
import com.springbatch.spring_batch_mastery_001.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public List<BookEntity> getAll(){

        log.info("call controller");
        return bookRepository.findAll();
    }

}
