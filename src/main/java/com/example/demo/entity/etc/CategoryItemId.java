package com.example.demo.entity.etc;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
public class CategoryItemId implements Serializable {

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "item_id")
    private Long itemId;

}
