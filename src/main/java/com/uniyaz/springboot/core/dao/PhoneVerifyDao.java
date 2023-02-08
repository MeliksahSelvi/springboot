package com.uniyaz.springboot.core.dao;

import com.uniyaz.springboot.core.domain.PhoneVerify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneVerifyDao extends JpaRepository<PhoneVerify, Long> {

    @Query("select count(phone) from PhoneVerify phoneVerify left join phoneVerify.phone phone where phone.localNumber =:phoneNumber")
    Long countVerifyNumber(@Param(value = "phoneNumber") String phoneNumber);
}
