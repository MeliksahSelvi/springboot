package com.uniyaz.springboot.core.converter;


import com.google.gson.Gson;
import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.dto.PhoneExampleDto;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class PhoneConverter {

    public PhoneDto convertBodyToPhoneDtoWithGson(HttpResponse<String> response) {
        String body = response.body();
        return new Gson().fromJson(body, PhoneDto.class);
    }

    public PhoneExampleDto convertBodyToPhoneExampleDtoWithGson(HttpResponse<String> response){
        String body=response.body();
        return new Gson().fromJson(body,PhoneExampleDto.class);
    }

    public Phone convertDtoToPhone(PhoneDto dto) {
        Phone phone = new Phone();
        phone.setLocalNumber(dto.getLocal_number());
        phone.setPhoneType(dto.getPhone_type());
        phone.setPhoneValid(dto.getPhone_valid());
        phone.setCarrier(dto.getCarrier());
        phone.setCountryName(dto.getCountry());
        return phone;
    }

    public CountVerifyNumberDto convertPhoneAndVerifyCountToDto(Phone phone,Long count){
        CountVerifyNumberDto dto=new CountVerifyNumberDto();
        dto.setLocalNumber(phone.getLocalNumber());
        dto.setCountVerify(count);

        return dto;
    }
}
