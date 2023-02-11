package com.uniyaz.springboot.core.domain;


import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "PHONE")
public class Phone {

    @SequenceGenerator(name = "generator", sequenceName = "PHONE_ID_SEQ")
    @GeneratedValue(generator = "generator", strategy = GenerationType.AUTO)
    @Column
    @Id
    private Long id;

    @Column(length = 20)
    private String localNumber;

    @Column(length = 30)
    private String phoneType;

    @Column(length = 100)
    private String countryName;

    @Column(length = 50)
    private String carrier;

    @Column(length = 5)
    private Boolean phoneValid;
}
