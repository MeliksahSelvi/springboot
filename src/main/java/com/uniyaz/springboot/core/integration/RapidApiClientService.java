package com.uniyaz.springboot.core.integration;

import com.uniyaz.springboot.core.converter.PhoneConverter;
import com.uniyaz.springboot.core.converter.PhoneVerifyConverter;
import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.domain.PhoneVerify;
import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.dto.PhoneExampleDto;
import com.uniyaz.springboot.core.service.PhoneService;
import com.uniyaz.springboot.core.service.PhoneVerifyService;
import com.uniyaz.springboot.utility.helper.Constanst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class RapidApiClientService {

    private final PhoneService phoneService;

    private final PhoneVerifyService phoneVerifyService;

    private final PhoneConverter phoneConverter;

    private final PhoneVerifyConverter phoneVerifyConverter;

    public PhoneDto verifyNumber(String phoneNumber) {
        HttpRequest httpRequest = createRequestVerifyNumber(phoneNumber);

        HttpResponse<String> response = createResponseWithRequest(httpRequest);

        PhoneDto phoneDto = phoneConverter.convertBodyToPhoneDtoWithGson(response);
        String trimNumber = trimString(phoneDto.getLocal_number());
        Phone phoneByNumber = phoneService.findPhoneByNumber(trimNumber);

        if (phoneByNumber != null) {
            PhoneVerify phoneVerify = phoneVerifyConverter.convertPhoneToPhoneVerify(phoneByNumber);
            phoneVerifyService.save(phoneVerify);
        }

        return phoneDto;
    }

    public CountVerifyNumberDto countOfVerifyNumber(String phoneNumber) {

        Phone phoneByNumber = phoneService.findPhoneByNumber(phoneNumber);
        Long countVerifyNumber = phoneVerifyService.countVerifyNumber(phoneNumber);
        CountVerifyNumberDto dto = phoneConverter.convertPhoneAndVerifyCountToDto(phoneByNumber, countVerifyNumber);
        return dto;
    }

    public PhoneExampleDto exampleNumber(String countryCode, String type) {
        HttpRequest httpRequest = createRequestExampleNumber(countryCode, type);
        HttpResponse<String> response = createResponseWithRequest(httpRequest);

        PhoneExampleDto phoneExampleDto = phoneConverter.convertBodyToPhoneExampleDtoWithGson(response);
        String trimNumber = trimString(phoneExampleDto.getLocal_number());
        Phone phoneByNumber = phoneService.findPhoneByNumber(trimNumber);

        if (phoneByNumber != null) {

            PhoneVerify phoneVerify = phoneVerifyConverter.convertPhoneToPhoneVerify(phoneByNumber);
            phoneVerifyService.save(phoneVerify);
        }

        return phoneExampleDto;
    }

    private String trimString(String trim) {
        return trim.replace(" ", "");
    }

    public Phone saveNumber(String phoneNumber) {
        HttpRequest httpRequest = createRequestVerifyNumber(phoneNumber);
        HttpResponse<String> responseWithRequest = createResponseWithRequest(httpRequest);

        PhoneDto phoneDto = phoneConverter.convertBodyToPhoneDtoWithGson(responseWithRequest);

        Phone phoneByNumber = phoneService.findPhoneByNumber(phoneDto.getLocal_number());
        if (phoneByNumber == null) {
            phoneByNumber = phoneConverter.convertDtoToPhone(phoneDto);
            phoneByNumber = phoneService.saveNumber(phoneByNumber);
        }

        return phoneByNumber;
    }

    private HttpRequest createRequestVerifyNumber(String phoneNumber) {
        String url = buildVerifyUrlWithParameters(phoneNumber);

        HttpRequest httpRequest = createRequest(url);

        return httpRequest;
    }

    private HttpRequest createRequestExampleNumber(String countryCode, String type) {
        String url = buildExampleUrlWithParameters(countryCode, type);

        HttpRequest httpRequest = createRequest(url);

        return httpRequest;
    }

    private HttpRequest createRequest(String url) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header(Constanst.KEY, Constanst.KEY_VALUE)
                .header(Constanst.HOST, Constanst.HOST_VALUE)
                .method(Constanst.METHOD_NAME, HttpRequest.BodyPublishers.noBody())
                .build();

        return httpRequest;
    }

    private String buildVerifyUrlWithParameters(String parameter) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constanst.VERIFY_URL)
                .append(parameter);

        return String.valueOf(stringBuilder);
    }

    private String buildExampleUrlWithParameters(String countryCode, String type) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constanst.EXAMPLE_URL)
                .append(countryCode)
                .append("&type=")
                .append(type);

        return String.valueOf(stringBuilder);
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
