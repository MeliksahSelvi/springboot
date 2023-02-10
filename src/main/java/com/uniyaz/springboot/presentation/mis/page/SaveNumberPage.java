package com.uniyaz.springboot.presentation.mis.page;

import com.uniyaz.springboot.core.integration.RapidApiClientService;
import com.uniyaz.springboot.presentation.mis.basepage.MelikHorizontalLayout;
import com.uniyaz.springboot.presentation.mis.basepage.MelikPage;
import com.uniyaz.springboot.presentation.mis.basepage.MelikSaveButton;
import com.uniyaz.springboot.presentation.mis.enums.NotificationMessage;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveNumberPage extends MelikPage {

    @Autowired
    RapidApiClientService rapidApiClientService;

    @Override
    public void createUI() {
        Panel numberPanel = createNumberPanel();
        componentEkle(numberPanel);
    }

    private Panel createNumberPanel() {
        Panel panel = new Panel();
        panel.setCaption("Numara Kayıt");
        MelikHorizontalLayout numberLayout = createNumberLayout();
        panel.setContent(numberLayout);

        return panel;
    }

    private MelikHorizontalLayout createNumberLayout() {
        MelikHorizontalLayout horizontalLayout = new MelikHorizontalLayout();

        FormLayout formLayout = new FormLayout();

        TextField numberField = new TextField();
        numberField.setCaption("Numara");
        formLayout.addComponent(numberField);

        MelikSaveButton saveButton = new MelikSaveButton();
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String phoneNumber = numberField.getValue();
                rapidApiClientService.saveNumber(phoneNumber);
                Notification.show(NotificationMessage.KAYIT_BASARILI.value(), Notification.Type.ASSISTIVE_NOTIFICATION);
            }
        });
        formLayout.addComponent(saveButton);

        horizontalLayout.addComponent(formLayout);
        return horizontalLayout;
    }
}
