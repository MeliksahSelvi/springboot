package com.uniyaz.springboot.rest;

import com.uniyaz.springboot.core.converter.PhoneConverter;
import com.uniyaz.springboot.core.converter.PhoneVerifyConverter;
import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.domain.PhoneVerify;
import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.service.PhoneService;
import com.uniyaz.springboot.core.service.PhoneVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    @GetMapping(path = "verifyNumber", params = "phone", produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneDto verifyNumber(@RequestParam(value = "phone") String phoneNumber) throws IOException, InterruptedException {

        HttpRequest httpRequest = createRequestWithParameters(phoneNumber);

        HttpResponse<String> response = createResponseWithRequest(httpRequest);

        PhoneDto phoneDto = phoneConverter.convertBodyToPhoneDtoWithGson(response);
        Phone phoneByNumber = phoneService.findPhoneByNumber(phoneDto.getLocal_number());

        PhoneVerify phoneVerify = phoneVerifyConverter.convertPhoneToPhoneVerify(phoneByNumber);
        phoneVerifyService.save(phoneVerify);

        return phoneDto;
    }

    @GetMapping(path = "countOfVerifyNumber",params = "phone",produces = MediaType.APPLICATION_JSON_VALUE)
    public CountVerifyNumberDto countOfVerifyNumber(@RequestParam(value = "phone") String phoneNumber){

        Phone phoneByNumber = phoneService.findPhoneByNumber(phoneNumber);
        Long countVerifyNumber = phoneVerifyService.countVerifyNumber(phoneNumber);
        CountVerifyNumberDto dto = phoneConverter.convertPhoneAndVerifyCountToDto(phoneByNumber, countVerifyNumber);
        return dto;
    }

    @GetMapping(path = "saveNumber",params = "phone",produces = MediaType.APPLICATION_JSON_VALUE)
    public Phone saveNumber(@RequestParam(value = "phone") String phoneNumber){

        HttpRequest httpRequest=createRequestWithParameters(phoneNumber);
        HttpResponse responseWithRequest = createResponseWithRequest(httpRequest);


        PhoneDto phoneDto = phoneConverter.convertBodyToPhoneDtoWithGson(responseWithRequest);
        Phone phone = phoneConverter.convertDtoToPhone(phoneDto);
        return phoneService.saveNumber(phone);
    }

    private String buildUrlWithParameters(String parameter) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("https://veriphone.p.rapidapi.com/verify?phone=")
                .append(parameter);

        return String.valueOf(stringBuilder);
    }

    private HttpRequest createRequestWithParameters(String phoneNumber) {
        String url = buildUrlWithParameters(phoneNumber);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "febe89f4bamsh68c82ec849630a4p148e7fjsnc2c924851fcc")
                .header("X-RapidAPI-Host", "veriphone.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        return httpRequest;
    }

    private HttpResponse createResponseWithRequest(HttpRequest httpRequest) {
        HttpResponse response;
        try {
            response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
