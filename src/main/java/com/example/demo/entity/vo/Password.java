package com.example.demo.entity.vo;

import com.example.demo.entity.constant.EncoderType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class Password {

    @Enumerated(EnumType.STRING)
    @Column(name = "encoder_type")
    private EncoderType encoderType;

    @Column(name = "password")
    private String password;

}
