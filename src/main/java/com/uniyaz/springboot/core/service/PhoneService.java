package com.uniyaz.springboot.core.service;

import com.uniyaz.springboot.core.dao.PhoneDao;
import com.uniyaz.springboot.core.domain.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneDao phoneDao;

    public Phone findPhoneByNumber(String phoneNumber) {
        return phoneDao.findPhoneByNumber(phoneNumber);
    }

    public Phone saveNumber(Phone phone) {
        return phoneDao.save(phone);
    }
}
