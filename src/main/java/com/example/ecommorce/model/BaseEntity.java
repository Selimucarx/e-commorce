package com.example.ecommorce.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    private UUID id;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;

    public UUID getId(){
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BaseEntity() {
        this.id = UUID.randomUUID();
        this.createDate = new Date();
    }
}
