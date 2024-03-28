package com.bank.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass // This will mark, this class as superclass and will be used further for extension
@Getter @Setter @ToString
public class BaseEntity {

    @Column(updatable = false) // meaning, don't change this value when updating the record
    private LocalDateTime createdAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false) // meaning, don't add or change this value when inserting a new row
    // This will be null by default and will be inserted as null value
    private LocalDateTime updatedAt;

    @Column(insertable = false)
    private String updatedBy;
}
