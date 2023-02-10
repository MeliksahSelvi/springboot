package com.uniyaz.springboot.presentation.mis.page;

import com.uniyaz.springboot.core.dto.CountVerifyNumberDto;
import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.core.integration.RapidApiClientService;
import com.uniyaz.springboot.presentation.mis.basepage.MelikHistoryButton;
import com.uniyaz.springboot.presentation.mis.basepage.MelikHorizontalLayout;
import com.uniyaz.springboot.presentation.mis.basepage.MelikPage;
import com.uniyaz.springboot.presentation.mis.basepage.MelikVerifyButton;
import com.uniyaz.springboot.presentation.mis.window.CountVerifNumberResponseWindow;
import com.uniyaz.springboot.presentation.mis.window.VerifyNumberResponseWindow;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

public class VerifyNumberPage extends MelikPage {

    @Autowired
    RapidApiClientService rapidApiClientService;

    private TextField numberField;

    @Override
    public void createUI() {
        Panel verifyPanel = createVerifyPanel();
        componentEkle(verifyPanel);
    }

    private Panel createVerifyPanel() {
        Panel panel = new Panel();
        panel.setCaption("Numara Sorgulama");
        MelikHorizontalLayout verifyLayout = createVerifyLayout();
        panel.setContent(verifyLayout);

        return panel;
    }

    private MelikHorizontalLayout createVerifyLayout() {
        MelikHorizontalLayout horizontalLayout = new MelikHorizontalLayout();

        FormLayout formLayout = new FormLayout();

        numberField = new TextField();
        numberField.setCaption("Numara");
        formLayout.addComponent(numberField);

        MelikVerifyButton verifyButton = new MelikVerifyButton();
        verifyButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                checkRequiredFields();

                String phoneNumber = numberField.getValue();
                PhoneDto phoneDto = rapidApiClientService.verifyNumber(phoneNumber);

                VerifyNumberResponseWindow window = new VerifyNumberResponseWindow("Numara Sorgulama", phoneDto);
                UI.getCurrent().addWindow(window);
                window.addCloseListener(new Window.CloseListener() {
                    @Override
                    public void windowClose(Window.CloseEvent closeEvent) {
                        clearFields();
                    }
                });
            }
        });
        formLayout.addComponent(verifyButton);

        MelikHistoryButton historyButton = new MelikHistoryButton();
        historyButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                checkRequiredFields();

                String phoneNumber = numberField.getValue();
                CountVerifyNumberDto countVerifyNumberDto = rapidApiClientService.countOfVerifyNumber(phoneNumber);

                CountVerifNumberResponseWindow window=new CountVerifNumberResponseWindow("Sorgulama Sayısı",countVerifyNumberDto);
                UI.getCurrent().addWindow(window);
                window.addCloseListener(new Window.CloseListener() {
                    @Override
                    public void windowClose(Window.CloseEvent closeEvent) {
                        clearFields();
                    }
                });

            }
        });
        formLayout.addComponent(historyButton);

        horizontalLayout.addComponent(formLayout);
        return horizontalLayout;
    }

    private void checkRequiredFields() {
        if (numberField.getValue() == null) {
            throw new RuntimeException("Numara Alanı Dolu Olmalı");
        }
    }

    private void clearFields(){
        numberField.clear();
    }
}
