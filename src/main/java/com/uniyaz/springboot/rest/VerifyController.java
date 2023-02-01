package com.uniyaz.springboot.rest;

import com.uniyaz.springboot.core.converter.PhoneConverter;
import com.uniyaz.springboot.core.converter.PhoneVerifyConverter;
import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.dto.PhoneExampleDto;
import com.uniyaz.springboot.core.integration.RapidApiClientService;
import com.uniyaz.springboot.core.service.PhoneService;
import com.uniyaz.springboot.core.service.PhoneVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class VerifyController {

    @Autowired
    PhoneService phoneService;

    @Autowired
    PhoneVerifyService phoneVerifyService;

    @Autowired
    PhoneConverter phoneConverter;

    @Autowired
    PhoneVerifyConverter phoneVerifyConverter;

    @Autowired
    RapidApiClientService rapidApiClientService;

    @GetMapping(path = "verifyNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneDto verifyNumber(@RequestParam(value = "phone") String phoneNumber) throws IOException, InterruptedException {
        PhoneDto phoneDto = rapidApiClientService.verifyNumber(phoneNumber);
        return phoneDto;
    }

    @GetMapping(path = "exampleNumber", params = {"country_code", "type"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneExampleDto exampleNumber(@RequestParam(value = "country_code") String countryCode, @RequestParam(value = "type") String type) throws IOException, InterruptedException {
        PhoneExampleDto phoneExampleDto = rapidApiClientService.exampleNumber(countryCode, type);
        return phoneExampleDto;
    }

    @GetMapping(path = "countOfVerifyNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountVerifyNumberDto countOfVerifyNumber(@RequestParam(value = "phone") String phoneNumber) {
        CountVerifyNumberDto dto = rapidApiClientService.countOfVerifyNumber(phoneNumber);
        return dto;
    }

    @GetMapping(path = "saveNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public Phone saveNumber(@RequestParam(value = "phone") String phoneNumber) {
        Phone phone = rapidApiClientService.saveNumber(phoneNumber);
        return phone;
    }
}
