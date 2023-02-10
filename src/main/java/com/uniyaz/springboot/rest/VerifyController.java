package com.uniyaz.springboot.rest;

import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.dto.PhoneExampleDto;
import com.uniyaz.springboot.core.integration.RapidApiClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class VerifyController {

    @Autowired
    RapidApiClientService rapidApiClientService;

    @GetMapping(path = "verifyNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneDto verifyNumber(@RequestParam(value = "phone") String phoneNumber) throws IOException, InterruptedException {
        PhoneDto phoneDto = rapidApiClientService.verifyNumber(phoneNumber);
        return phoneDto;
    }
    //postman'da parametreyi url ile değil body form data olarak göndermek için post methodu eklendi.
    @PostMapping(path = "verifyNumber2", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneDto verifyNumber2(@RequestParam(value = "phone") String phoneNumber) throws IOException, InterruptedException {
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

    @PutMapping(path = "saveNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public Phone saveNumber(@RequestParam(value = "phone") String phoneNumber) {
        Phone phone = rapidApiClientService.saveNumber(phoneNumber);
        return phone;
    }
}
