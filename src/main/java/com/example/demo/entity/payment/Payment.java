package com.example.demo.entity.payment;


import com.example.demo.entity.mappedsuper.BaseEntity;
import com.example.demo.entity.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Payments")
@DiscriminatorColumn(name = "payment_type")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Payment extends BaseEntity {

    //  PaymentMethod

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //  UUID

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
