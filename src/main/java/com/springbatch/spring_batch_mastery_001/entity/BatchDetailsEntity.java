package com.springbatch.spring_batch_mastery_001.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "batch_details_entity")
@Data
public class BatchDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batch_id;

    private String merchant_id;

    private String batch_date;

    private String request_id;

    private String merchant_ref_number;

    private String TransactionReferenceNumber;

    private String payment_type;

    private String currency;

    private String amount;
    private String ics_applications;

    private String status;
    private String percentage;
    private String netAmount;
    private String transaction_date;

}
