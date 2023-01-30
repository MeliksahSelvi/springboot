package com.uniyaz.springboot.core.dto;

public class PhoneDto {

    private String status;
    private String phone;
    private String phone_valid;
    private String phone_type;
    private String phone_region;
    private String country;
    private String country_code;
    private String country_prefix;
    private String international_number;
    private String local_number;
    private String e164;
    private String carrier;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone_valid() {
        return phone_valid;
    }

    public void setPhone_valid(String phone_valid) {
        this.phone_valid = phone_valid;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
    }

    public String getPhone_region() {
        return phone_region;
    }

    public void setPhone_region(String phone_region) {
        this.phone_region = phone_region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_prefix() {
        return country_prefix;
    }

    public void setCountry_prefix(String country_prefix) {
        this.country_prefix = country_prefix;
    }

    public String getInternational_number() {
        return international_number;
    }

    public void setInternational_number(String international_number) {
        this.international_number = international_number;
    }

    public String getLocal_number() {
        return local_number;
    }

    public void setLocal_number(String local_number) {
        this.local_number = local_number;
    }

    public String getE164() {
        return e164;
    }

    public void setE164(String e164) {
        this.e164 = e164;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}
