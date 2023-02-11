package com.uniyaz.springboot.core.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
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
}
