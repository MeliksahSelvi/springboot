package com.uniyaz.springboot.core.dao;

import com.uniyaz.springboot.core.domain.PhoneVerify;
import com.uniyaz.springboot.helper.HelperFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneVerifyDao {

    public Long countVerifyNumber(String phoneNumber) {
        String hql = "select count(phone) from PhoneVerify phoneVerify left join phoneVerify.phone phone where phone.localNumber =:phoneNumber";
        SessionFactory sessionFactory = HelperFactory.getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery(hql);

        return (Long) query.uniqueResult();
    }

    public PhoneVerify save(PhoneVerify phoneVerify) {
        try {
            SessionFactory sessionFactory = HelperFactory.getSessionFactory();
            Session currentSession = sessionFactory.getCurrentSession();
            Transaction transaction = currentSession.beginTransaction();
            phoneVerify = (PhoneVerify) currentSession.merge(phoneVerify);
            transaction.commit();
            currentSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return phoneVerify;
    }
}
