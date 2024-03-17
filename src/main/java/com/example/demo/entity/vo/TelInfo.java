package com.example.demo.entity.vo;

import com.example.demo.entity.constant.NewsAgency;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class TelInfo {

    @Column(name = "agency")
    @Enumerated(EnumType.STRING)
    private NewsAgency agency;

    @Column(name = "tel_number")
    private String telNumber;

}
