package com.uniyaz.springboot.core.integration;

import com.google.gson.Gson;
import com.uniyaz.springboot.core.converter.PhoneConverter;
import com.uniyaz.springboot.core.converter.PhoneVerifyConverter;
import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.domain.PhoneVerify;
import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.dto.PhoneExampleDto;
import com.uniyaz.springboot.core.service.PhoneService;
import com.uniyaz.springboot.core.service.PhoneVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class RapidApiClientService {

    @Autowired
    PhoneService phoneService;

    @Autowired
    PhoneVerifyService phoneVerifyService;

    @Autowired
    PhoneConverter phoneConverter;

    @Autowired
    PhoneVerifyConverter phoneVerifyConverter;

    public PhoneDto verifyNumber(String phoneNumber){
        HttpRequest httpRequest = createRequestVerifyNumber(phoneNumber);

        HttpResponse<String> response = createResponseWithRequest(httpRequest);

        PhoneDto phoneDto = phoneConverter.convertBodyToPhoneDtoWithGson(response);
        Phone phoneByNumber = phoneService.findPhoneByNumber(phoneDto.getLocal_number());

        PhoneVerify phoneVerify = phoneVerifyConverter.convertPhoneToPhoneVerify(phoneByNumber);
        phoneVerifyService.save(phoneVerify);

        return phoneDto;
    }

    public CountVerifyNumberDto countOfVerifyNumber(String phoneNumber) {

        Phone phoneByNumber = phoneService.findPhoneByNumber(phoneNumber);
        Long countVerifyNumber = phoneVerifyService.countVerifyNumber(phoneNumber);
        return phoneConverter.convertPhoneAndVerifyCountToDto(phoneByNumber, countVerifyNumber);
    }

    public PhoneExampleDto exampleNumber(String countryCode, String type) {
        HttpRequest httpRequest = createRequestExampleNumber(countryCode, type);
        HttpResponse<String> response = createResponseWithRequest(httpRequest);
        String body = response.body();

        PhoneExampleDto phoneExampleDto = new Gson().fromJson(body, PhoneExampleDto.class);
        Phone phoneByNumber = phoneService.findPhoneByNumber(phoneExampleDto.getLocal_number());

        PhoneVerify phoneVerify = phoneVerifyConverter.convertPhoneToPhoneVerify(phoneByNumber);
        phoneVerifyService.save(phoneVerify);

        return phoneExampleDto;
    }

    public Phone saveNumber(String phoneNumber) {
        HttpRequest httpRequest = createRequestVerifyNumber(phoneNumber);
        HttpResponse<String> responseWithRequest = createResponseWithRequest(httpRequest);
        String body = responseWithRequest.body();
        PhoneDto phoneDto = new Gson().fromJson(body, PhoneDto.class);
        Phone phone = phoneConverter.convertDtoToPhone(phoneDto);
        return phoneService.saveNumber(phone);
    }

    private HttpRequest createRequestVerifyNumber(String phoneNumber) {
        String url = buildVerifyUrlWithParameters(phoneNumber);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "febe89f4bamsh68c82ec849630a4p148e7fjsnc2c924851fcc")
                .header("X-RapidAPI-Host", "veriphone.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        return httpRequest;
    }

    private String buildVerifyUrlWithParameters(String parameter) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("https://veriphone.p.rapidapi.com/verify?phone=")
                .append(parameter);

        return String.valueOf(stringBuilder);
    }

    private String buildExampleUrlWithParameters(String countryCode, String type) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("https://veriphone.p.rapidapi.com/example?country_code=")
                .append(countryCode)
                .append("&type=")
                .append(type);

        return String.valueOf(stringBuilder);
    }

    private HttpRequest createRequestExampleNumber(String countryCode, String type) {
        String url = buildExampleUrlWithParameters(countryCode, type);

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
