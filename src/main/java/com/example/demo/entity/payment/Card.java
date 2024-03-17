package com.example.demo.entity.payment;

import com.example.demo.entity.constant.CardType;
import com.example.demo.entity.vo.CardInfo;
import jakarta.persistence.*;

@Entity
public class Card extends Payment {
    
    @Embedded
    private CardInfo cardInfo;

}
