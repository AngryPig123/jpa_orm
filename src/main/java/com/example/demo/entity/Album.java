package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ALBUM")
public class Album extends Item {

    @Column(name = "artist")
    private String artist;

    @Column(name = "etc")
    private String etc;

}
