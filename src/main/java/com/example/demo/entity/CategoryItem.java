package com.example.demo.entity;

import com.example.demo.entity.etc.CategoryItemId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryItem {

    @EmbeddedId
    private CategoryItemId id;

    @ManyToOne
    @MapsId("categoryId")
    private Category category;

    @ManyToOne
    @MapsId("itemId")
    private Item item;

}
