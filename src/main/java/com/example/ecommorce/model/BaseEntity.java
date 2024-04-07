package com.example.ecommorce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Id
    private UUID id;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;

    @PrePersist
    protected void onCreate() {
        this.id = UUID.randomUUID();
        this.createDate = new Date();
    }
}
