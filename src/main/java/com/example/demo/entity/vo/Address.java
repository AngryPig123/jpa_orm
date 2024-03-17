package com.example.demo.entity.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "detail_address")
    private String detailAddress;

}
