package com.uniyaz.springboot.core.dto;

public class CountVerifyNumberDto {

    private String localNumber;
    private Long countVerify;

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public Long getCountVerify() {
        return countVerify;
    }

    public void setCountVerify(Long countVerify) {
        this.countVerify = countVerify;
    }
}
