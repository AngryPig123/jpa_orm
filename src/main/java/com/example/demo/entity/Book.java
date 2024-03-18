package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ALBUM")
public class Book extends Item {

    @Column(name = "artist")
    private String artist;

    @Column(name = "isbn", unique = true)
    private String isbn;

}
