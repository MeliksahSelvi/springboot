package com.uniyaz.springboot.presentation.mis.window;

import com.uniyaz.springboot.core.dto.PhoneDto;
import com.uniyaz.springboot.presentation.mis.basepage.BaseWindow;
import com.uniyaz.springboot.presentation.mis.basepage.MelikHorizontalLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class VerifyNumberResponseWindow extends BaseWindow {

    private TextField statusField;
    private TextField phoneNumberField;
    private TextField phoneValidField;
    private TextField phoneTypeField;
    private TextField phoneRegionField;
    private TextField countryField;
    private TextField countryCodeField;
    private TextField countryPrefixField;
    private TextField internationalNumberField;
    private TextField localNumberField;
    private TextField e164Field;
    private TextField carrierField;

    public VerifyNumberResponseWindow(String caption, PhoneDto phoneDto) {
        super(caption);
        fillFieldWithDto(phoneDto);
    }

    private void fillFieldWithDto(PhoneDto phoneDto) {

        String status = phoneDto.getStatus();
        if (status != null) {
            statusField.setValue(status);
        }

        String phone = phoneDto.getPhone();
        if (phone != null) {
            phoneNumberField.setValue(phone);
        }

        String phoneValid = phoneDto.getPhone_valid();
        if (phoneValid != null) {
            phoneValidField.setValue(phoneValid);
        }

        String phoneType = phoneDto.getPhone_type();
        if (phoneType != null) {
            phoneTypeField.setValue(phoneType);
        }

        String phoneRegion = phoneDto.getPhone_region();
        if (phoneRegion != null) {
            phoneRegionField.setValue(phoneRegion);
        }

        String country = phoneDto.getCountry();
        if (country != null) {
            countryField.setValue(country);
        }

        String countryPrefix = phoneDto.getCountry_prefix();
        if (countryPrefix != null) {
            countryPrefixField.setValue(countryPrefix);
        }

        String internationalNumber = phoneDto.getInternational_number();
        if (internationalNumber != null) {
            internationalNumberField.setValue(internationalNumber);
        }

        String localNumber = phoneDto.getLocal_number();
        if (localNumber != null) {
            localNumberField.setValue(localNumber);
        }

        String e164 = phoneDto.getE164();
        if (e164 != null) {
            e164Field.setValue(e164);
        }

        String carrier = phoneDto.getCarrier();
        if (carrier != null) {
            carrierField.setValue(carrier);
        }
    }

    @Override
    public void createUI() {
        Panel responsePanel = createResponsePanel();
        componentEkle(responsePanel);
    }

    private Panel createResponsePanel() {
        Panel panel = new Panel();
        panel.setCaption("Sorgulama Sonuç");
        MelikHorizontalLayout responseLayout = createResponseLayout();
        panel.setContent(responseLayout);

        return panel;
    }

    private MelikHorizontalLayout createResponseLayout() {
        MelikHorizontalLayout horizontalLayout = new MelikHorizontalLayout();
        horizontalLayout.setEnabled(false);

        FormLayout formLayout = createFormLayout1();
        FormLayout formLayout2 = createFormLayout2();
        FormLayout formLayout3 = createFormLayout3();

        horizontalLayout.addComponent(formLayout);
        horizontalLayout.addComponent(formLayout2);
        horizontalLayout.addComponent(formLayout3);

        return horizontalLayout;
    }

    private FormLayout createFormLayout1() {
        FormLayout formLayout = new FormLayout();

        statusField = new TextField();
        statusField.setCaption("Status");
        formLayout.addComponent(statusField);

        phoneNumberField = new TextField();
        phoneNumberField.setCaption("Phone");
        formLayout.addComponent(phoneNumberField);

        phoneValidField = new TextField();
        phoneValidField.setCaption("Phone Valid");
        formLayout.addComponent(phoneValidField);

        phoneTypeField = new TextField();
        phoneTypeField.setCaption("Phone Type");
        formLayout.addComponent(phoneTypeField);

        return formLayout;
    }

    private FormLayout createFormLayout2() {
        FormLayout formLayout = new FormLayout();

        phoneRegionField = new TextField();
        phoneRegionField.setCaption("Status");
        formLayout.addComponent(phoneRegionField);

        countryField = new TextField();
        countryField.setCaption("Phone");
        formLayout.addComponent(countryField);

        countryCodeField = new TextField();
        countryCodeField.setCaption("Phone Valid");
        formLayout.addComponent(countryCodeField);

        countryPrefixField = new TextField();
        countryPrefixField.setCaption("Phone Type");
        formLayout.addComponent(countryPrefixField);

        return formLayout;
    }

    private FormLayout createFormLayout3() {
        FormLayout formLayout = new FormLayout();

        internationalNumberField = new TextField();
        internationalNumberField.setCaption("Status");
        formLayout.addComponent(internationalNumberField);

        localNumberField = new TextField();
        localNumberField.setCaption("Phone");
        formLayout.addComponent(localNumberField);

        e164Field = new TextField();
        e164Field.setCaption("Phone Valid");
        formLayout.addComponent(e164Field);

        carrierField = new TextField();
        carrierField.setCaption("Phone Type");
        formLayout.addComponent(carrierField);

        return formLayout;
    }
}
