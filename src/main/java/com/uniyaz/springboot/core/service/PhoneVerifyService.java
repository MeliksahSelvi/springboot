package com.uniyaz.springboot.core.service;

import com.uniyaz.springboot.core.dao.PhoneVerifyDao;
import com.uniyaz.springboot.core.domain.PhoneVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneVerifyService {

    @Autowired
    PhoneVerifyDao phoneVerifyDao;

    public void save(PhoneVerify phoneVerify) {
        phoneVerifyDao.save(phoneVerify);
    }

    public Long countVerifyNumber(String phoneNumber) {
        return phoneVerifyDao.countVerifyNumber(phoneNumber);
    }
}
