package com.bank.accounts.entity;

import com.bank.accounts.audit.AuditAwareImpl;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // This will mark, this class as superclass and will be used further for extension
@EntityListeners(AuditingEntityListener.class) // This will tell, which class to be used for auditing
@Getter @Setter @ToString
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false) // meaning, don't change this value when updating the record
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false) // meaning, don't add or change this value when inserting a new row
    // This will be null by default and will be inserted as null value
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
