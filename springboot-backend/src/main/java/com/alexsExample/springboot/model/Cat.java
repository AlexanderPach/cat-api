package com.alexsExample.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "image_url", nullable = false)
    private String image_url;
    @Column(name = "description", nullable = false)
    private String description;

}
