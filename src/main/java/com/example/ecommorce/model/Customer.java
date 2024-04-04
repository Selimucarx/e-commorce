package com.example.ecommorce.model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@Entity
public class Customer extends BaseEntity{
    private String email;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
        this.createDate = new Date();
    }
}
