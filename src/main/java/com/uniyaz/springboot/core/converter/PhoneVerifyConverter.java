package com.uniyaz.springboot.core.converter;

import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.core.domain.PhoneVerify;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PhoneVerifyConverter {

    public PhoneVerify convertPhoneToPhoneVerify(Phone phone){

        PhoneVerify phoneVerify=new PhoneVerify();
        phoneVerify.setPhone(phone);
        phoneVerify.setVerifyDate(new Date());

        return phoneVerify;
    }
}
