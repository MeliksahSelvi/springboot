package com.uniyaz.springboot.presentation.mis.window;

import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.presentation.mis.basepage.BaseWindow;
import com.uniyaz.springboot.presentation.mis.basepage.MelikHorizontalLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class CountVerifNumberResponseWindow extends BaseWindow {

    private TextField localNumberField;
    private TextField countVerifyField;


    public CountVerifNumberResponseWindow(String caption, CountVerifyNumberDto countVerifyNumberDto) {
        super(caption);
        fillFieldWithDto(countVerifyNumberDto);
    }

    private void fillFieldWithDto(CountVerifyNumberDto countVerifyNumberDto) {
        String localNumber = countVerifyNumberDto.getLocalNumber();
        if (localNumber != null) {
            localNumberField.setValue(localNumber);
        }

        Long countVerify = countVerifyNumberDto.getCountVerify();
        if (countVerify != null) {
            countVerifyField.setValue(String.valueOf(countVerify));
        }
    }

    @Override
    public void createUI() {
        Panel responsePanel = createResponsePanel();
        componentEkle(responsePanel);
    }

    private Panel createResponsePanel() {
        Panel panel = new Panel();
        panel.setCaption("Sorgulama Sayısı Sonuç");
        MelikHorizontalLayout responseLayout = createResponseLayout();
        panel.setContent(responseLayout);

        return panel;
    }

    private MelikHorizontalLayout createResponseLayout() {
        MelikHorizontalLayout horizontalLayout = new MelikHorizontalLayout();
        horizontalLayout.setEnabled(false);

        FormLayout formLayout = new FormLayout();

        localNumberField = new TextField();
        localNumberField.setCaption("Numara");
        formLayout.addComponent(localNumberField);

        countVerifyField = new TextField();
        countVerifyField.setCaption("Sorgulama Sayısı");
        formLayout.addComponent(countVerifyField);

        horizontalLayout.addComponent(formLayout);

        return horizontalLayout;
    }
}
