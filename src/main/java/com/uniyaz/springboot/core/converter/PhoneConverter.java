package com.uniyaz.springboot.core.converter;


import com.google.gson.Gson;
import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.dto.PhoneExampleDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;


@Component
public class PhoneConverter {

    public PhoneDto convertBodyToPhoneDtoWithGson(HttpResponse<String> response) {
        String body = response.body();
        return new Gson().fromJson(body, PhoneDto.class);
    }

    public PhoneExampleDto convertBodyToPhoneExampleDtoWithGson(HttpResponse<String> response) {
        String body = response.body();
        return new Gson().fromJson(body, PhoneExampleDto.class);
    }

    public Phone convertDtoToPhone(PhoneDto dto) {
        Phone phone = new Phone();
        String trim = dto.getLocal_number().replace(" ", "");
        phone.setLocalNumber(trim);
        phone.setPhoneType(dto.getPhone_type());
        phone.setPhoneValid(dto.getPhone_valid());
        phone.setCarrier(dto.getCarrier());
        phone.setCountryName(dto.getCountry());
        return phone;
    }

    public CountVerifyNumberDto convertPhoneAndVerifyCountToDto(Phone phone, Long count) {
        String localNumber = phone != null ? phone.getLocalNumber() : "-";
        String status = phone != null ? HttpStatus.OK.getReasonPhrase() : HttpStatus.NO_CONTENT.getReasonPhrase();

        CountVerifyNumberDto dto = CountVerifyNumberDto.builder()
                .localNumber(localNumber)
                .countVerify(count)
                .status(status)
                .build();
        return dto;
    }
}
