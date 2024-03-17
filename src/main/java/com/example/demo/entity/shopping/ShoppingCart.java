package com.example.demo.entity.shopping;

import com.example.demo.entity.mappedsuper.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "shopping_cart")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShoppingCart extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopping_id")
    private Shopping shopping;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
