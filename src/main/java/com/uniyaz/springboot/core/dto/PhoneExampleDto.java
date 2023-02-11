package com.uniyaz.springboot.core.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneExampleDto {

    private String status;
    private String phone_type;
    private String country_code;
    private String country_prefix;
    private String internatiaonal_number;
    private String local_number;
    private String e164;
}
