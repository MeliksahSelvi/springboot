package com.uniyaz.springboot.core.domain;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PHONE_VERIFY")
public class PhoneVerify {

    @SequenceGenerator(name = "generator", sequenceName = "PHONE_VERIFY_ID_SEQ")
    @GeneratedValue(generator = "generator", strategy = GenerationType.AUTO)
    @Column
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PHONE", foreignKey = @ForeignKey(name = "FK_PHONE_VERIFY_PHONE"))
    private Phone phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date verifyDate;

    @Override
    public String toString() {
        return "-";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }
}
