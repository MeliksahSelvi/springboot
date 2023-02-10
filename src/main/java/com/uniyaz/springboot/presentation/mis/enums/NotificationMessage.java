package com.uniyaz.springboot.presentation.mis.enums;

import com.uniyaz.springboot.presentation.mis.markerpage.BaseEnum;

public enum NotificationMessage implements BaseEnum {
    KAYIT_BASARILI("Kayıt İşlemi Başarılı");

    private final String messageType;

    NotificationMessage(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String value() {
        return messageType;
    }
}
