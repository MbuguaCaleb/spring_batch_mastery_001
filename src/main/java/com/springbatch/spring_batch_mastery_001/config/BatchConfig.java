package com.springbatch.spring_batch_mastery_001.config;

import com.springbatch.spring_batch_mastery_001.batch.*;
import com.springbatch.spring_batch_mastery_001.entity.BookEntity;
import com.springbatch.spring_batch_mastery_001.repository.MerchantCategoryCodesRepository;
import com.springbatch.spring_batch_mastery_001.repository.MerchantOnBoardingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    private final MerchantCategoryCodesRepository merchantCategoryCodesRepository;

    private final MerchantOnBoardingRepository merchantOnBoardingRepository;
    //we shall create a Job to read a file
    //Inside the Job, we shall create the Steps (Reader, Writer, Processor

    //we need the jobRepository & transactionManager as dependencies for our steps
    //A job takes in a Step
    @Bean
    public Job bookReaderJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("bookReadJob", jobRepository)
                .incrementer(new RunIdIncrementer())
//                .start(chunkStep(jobRepository, transactionManager))
                .start(taskletStep(jobRepository,transactionManager))
                .build();
    }


    //the chunk step has the csvReader,processor and writer
    //I will be reading my CSV up to 10 records
    //Then i process the 10 records
    //After processing is done, then i write
    @Bean
    public Step chunkStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("bookReaderStep", jobRepository).<BookEntity, BookEntity>
                        chunk(10, transactionManager)
                .reader(csvReader())
                .processor(processor())
                .writer(writer())
                .build();
    }


    @StepScope
    @Bean
    public ItemWriter<BookEntity> writer() {
        return new BookWriter();
    }


    @Bean
    @StepScope
    public ItemProcessor<BookEntity, BookEntity> processor() {
        CompositeItemProcessor<BookEntity, BookEntity> processor = new CompositeItemProcessor<>();
        processor.setDelegates(List.of(new BookTitleProcessor(), new BookAuthorProcessor()));
        return processor;
    }


    //Creating my csvReader config
    //StepScope, means that this is a Bean in the scope of the Step
    @Bean
    @StepScope
    public FlatFileItemReader<BookEntity> csvReader() {
        return new FlatFileItemReaderBuilder<BookEntity>()
                .name("bookReader")
                .resource(new ClassPathResource("book_data.csv"))
                .delimited()
                .names(new String[]{"title", "author", "year_of_publishing"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(BookEntity.class);
                }})
                .build();
    }


    @Bean
    @StepScope
    public ItemReader<BookEntity> restBookReader() {
        return new RestBookReader("http://localhost:8080/api/v1/books", new RestTemplate());
    }


    //Configuring a taskLetStep
    @Bean
    public Step taskletStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("taskletStep", jobRepository)
                .tasklet(new BookTasklet(), platformTransactionManager)
                .build();

    }

}
