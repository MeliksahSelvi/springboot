package com.uniyaz.springboot.rest;

import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.dto.PhoneExampleDto;
import com.uniyaz.springboot.core.integration.RapidApiClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/melik")
@Tag(description = "Veriphone API", name = "Verify Controller")
public class VerifyController {

    @Autowired
    RapidApiClientService rapidApiClientService;

    @Operation(description = "Verify Number With GET Method")
    @GetMapping(path = "verifyNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneDto verifyNumber(@RequestParam(value = "phone") String phoneNumber) {
        PhoneDto phoneDto = rapidApiClientService.verifyNumber(phoneNumber);
        return phoneDto;
    }

    @Operation(description = "Verify Number With POST Method")
    @PostMapping(path = "verifyNumber2", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneDto verifyNumber2(@RequestParam(value = "phone") String phoneNumber) {
        PhoneDto phoneDto = rapidApiClientService.verifyNumber(phoneNumber);
        return phoneDto;
    }

    @Operation(description = "Other Verify Number Method")
    @GetMapping(path = "exampleNumber", params = {"country_code", "type"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneExampleDto exampleNumber(@RequestParam(value = "country_code") String countryCode, @RequestParam(value = "type") String type) {
        PhoneExampleDto phoneExampleDto = rapidApiClientService.exampleNumber(countryCode, type);
        return phoneExampleDto;
    }

    @Operation(description = "Count Of Verify The Given Number")
    @GetMapping(path = "countOfVerifyNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountVerifyNumberDto countOfVerifyNumber(@RequestParam(value = "phone") String phoneNumber) {
        CountVerifyNumberDto dto = rapidApiClientService.countOfVerifyNumber(phoneNumber);
        return dto;
    }

    @Operation(description = "Save The Given Number")
    @PutMapping(path = "saveNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public Phone saveNumber(@RequestParam(value = "phone") String phoneNumber) {
        Phone phone = rapidApiClientService.saveNumber(phoneNumber);
        return phone;
    }
}
