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
@Entity(name = "tbl_merchant_onboarding")
@EntityListeners(AuditingEntityListener.class)
public class MerchantOnBoardingEntity {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "shortcode")
    private String shortcode;

    @Column(name = "shortcode_name")
    private String shortcodeName;

    @Column(name = "msisdn")
    private String msisdn;

    @Column(name = "operator_id")
    private String operatorId;

    @Column(name = "till_no")
    private String tillNo;

    @Column(name = "merchant_category_code")
    private String merchantCategoryCode;

    @Column(name = "cp_organization_id")
    private String cardPresentOrganisationID;

    @Column(name = "cnp_organization_id")
    private String cardNotPresentOrganisationID;

    @Column(name = "parent_organization_id")
    private String parentOrganizationId;

    @Column(name = "onboarding_status")
    private String onBoardingStatus;

    @Column(name = "cybersource_result_desc")
    private String cyberSourceResultDesc;

    @Column(name = "mpesa_result_desc")
    private String mpesaResultDesc;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;
}
