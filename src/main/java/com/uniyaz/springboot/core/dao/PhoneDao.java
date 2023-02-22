package com.uniyaz.springboot.core.dao;

import com.uniyaz.springboot.core.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhoneDao extends JpaRepository<Phone, Long> {

    @Query("select phone From Phone phone where phone.localNumber =:phoneNumber")
    Phone findPhoneByNumber(@Param(value = "phoneNumber") String phoneNumber);
}
