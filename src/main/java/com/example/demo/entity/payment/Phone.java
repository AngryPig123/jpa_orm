package com.example.demo.entity.payment;

import com.example.demo.entity.vo.TelInfo;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Phone extends Payment {

    @Embedded
    private TelInfo telInfo;

}
