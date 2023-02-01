package com.uniyaz.springboot.core.dto;

public class PhoneExampleDto {

    private String status;
    private String phone_type;
    private String country_code;
    private String country_prefix;
    private String internatiaonal_number;
    private String local_number;
    private String e164;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
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

    public String getInternatiaonal_number() {
        return internatiaonal_number;
    }

    public void setInternatiaonal_number(String internatiaonal_number) {
        this.internatiaonal_number = internatiaonal_number;
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
}
