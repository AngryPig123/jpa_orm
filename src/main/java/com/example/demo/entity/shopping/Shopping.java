package com.example.demo.entity.shopping;

import com.example.demo.entity.mappedsuper.BaseEntity;
import com.example.demo.entity.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "shopping")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shopping extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
}
