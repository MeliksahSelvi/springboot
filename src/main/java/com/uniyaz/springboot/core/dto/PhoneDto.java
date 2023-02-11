package com.uniyaz.springboot.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneDto {

    private String status;
    private String phone;
    private Boolean phone_valid;
    private String phone_type;
    private String phone_region;
    private String country;
    private String country_code;
    private String country_prefix;
    private String international_number;
    private String local_number;
    private String e164;
    private String carrier;
}
