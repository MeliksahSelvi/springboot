package com.uniyaz.springboot.core.dao;

import com.uniyaz.springboot.core.domain.Phone;
import com.uniyaz.springboot.helper.HelperFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneDao {

    public Phone findPhoneByNumber(String phoneNumber) {

        String hql = "select phone From Phone phone where phone.localNumber =:phone";
        SessionFactory sessionFactory = HelperFactory.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);
        query.setParameter("phone",phoneNumber);
        return (Phone) query.uniqueResult();
    }

    public Phone save(Phone phone) {
        try {
            SessionFactory sessionFactory = HelperFactory.getSessionFactory();
            Session currentSession = sessionFactory.getCurrentSession();
            Transaction transaction = currentSession.beginTransaction();
            phone = (Phone) currentSession.merge(phone);
            transaction.commit();
            currentSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return phone;
    }
}
