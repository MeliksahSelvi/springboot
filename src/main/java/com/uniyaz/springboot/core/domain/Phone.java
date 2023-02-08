package com.uniyaz.springboot.core.domain;


import jakarta.persistence.*;

@Entity
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
    private String phoneValid;

    @Override
    public String toString() {
        return id != null ? localNumber : "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getPhoneValid() {
        return phoneValid;
    }

    public void setPhoneValid(String phoneValid) {
        this.phoneValid = phoneValid;
    }
}
