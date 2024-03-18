package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ALBUM")
public class Movie extends Item {

    @Column(name = "director")
    private String director;

    @Column(name = "actor")
    private String actor;

}
