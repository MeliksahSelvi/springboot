package com.uniyaz.springboot.presentation.mis.basepage;

import com.uniyaz.springboot.presentation.mis.markerpage.IMelikPage;
import com.vaadin.ui.Component;

public abstract class MelikPage implements IMelikPage {

    private MelikVerticalLayout mainLayout = new MelikVerticalLayout();

    public MelikPage() {
        createUI();
    }

    public abstract void createUI();

    public void componentEkle(Component component) {
        mainLayout.addComponent(component);
    }

    public void componentSil(Component component) {
        mainLayout.removeComponent(component);
    }

    public void tumComponentleriSil() {
        mainLayout.removeAllComponents();
    }

    @Override
    public Component tumSayfaView() {
        return mainLayout;
    }
}
