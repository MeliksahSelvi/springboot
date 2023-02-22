package com.uniyaz.springboot.core.service;

import com.uniyaz.springboot.core.dao.PhoneVerifyDao;
import com.uniyaz.springboot.core.domain.PhoneVerify;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneVerifyService {

    private final PhoneVerifyDao phoneVerifyDao;

    public void save(PhoneVerify phoneVerify) {
        phoneVerifyDao.save(phoneVerify);
    }

    public Long countVerifyNumber(String phoneNumber) {
        return phoneVerifyDao.countVerifyNumber(phoneNumber);
    }
}
