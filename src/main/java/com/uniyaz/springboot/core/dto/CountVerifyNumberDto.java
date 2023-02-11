package com.uniyaz.springboot.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountVerifyNumberDto {

    private String localNumber;
    private Long countVerify;
    private String status;

}
