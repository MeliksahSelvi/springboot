package com.uniyaz.springboot.core.service;

import com.uniyaz.springboot.core.dao.PhoneDao;
import com.uniyaz.springboot.core.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    PhoneDao phoneDao;

    public Phone findPhoneByNumber(String phoneNumber){
        return phoneDao.findPhoneByNumber(phoneNumber);
    }

    public Phone saveNumber(Phone phone){
        return phoneDao.save(phone);
    }
}
