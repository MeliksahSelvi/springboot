package com.uniyaz.springboot.presentation.common;

import com.uniyaz.springboot.presentation.mis.page.VerifyNumberPage;
import com.uniyaz.springboot.presentation.mis.basepage.MelikTabSheet;
import com.uniyaz.springboot.presentation.mis.basepage.MelikVerticalLayout;
import com.uniyaz.springboot.presentation.mis.page.SaveNumberPage;
import com.vaadin.flow.router.Route;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Route
public class MelikApplication extends UI {

    private MelikVerticalLayout mainLayout;
    private MelikTabSheet tabSheet;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        getReconnectDialogConfiguration().setDialogText("Sunucu bağlantısı kesildi, yeniden bağlanılmaya çalışılıyor...");
        getReconnectDialogConfiguration().setDialogTextGaveUp("Sunucu bağlantısı kesildi.");

        mainLayout = new MelikVerticalLayout();
        setContent(mainLayout);

        tabSheet = new MelikTabSheet();
        mainLayout.addComponent(tabSheet);

        tabSheet.tabEkle(SaveNumberPage.class.getName(), "Numara Kayıt");
        tabSheet.tabEkle(VerifyNumberPage.class.getName(),"Numara Sorgulama");
    }
}
