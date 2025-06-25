package com.springbatch.spring_batch_mastery_001.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_merchant_category_codes")
@EntityListeners(AuditingEntityListener.class)
public class MerchantCategoryCodesEntity {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_category_code")
    private String merchantCategoryCode;

    @Column(name = "merchant_category_name")
    private String merchantCategoryName;

    @Column(name = "cp_product_template_id")
    private String cardPresentProductTemplateId;

    @Column(name = "percentage_charge")
    private String percentageCharge;

    @Column(name = "cnp_product_template_id")
    private String cardNotPresentProductTemplateId;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;


}
