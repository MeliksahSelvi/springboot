package com.uniyaz.springboot.presentation.mis.basepage;

import com.uniyaz.springboot.presentation.mis.markerpage.IMelikPage;
import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

public abstract class BaseWindow extends Window implements IMelikPage {

    private MelikVerticalLayout mainLayout;

    public BaseWindow(String caption) {
        super(caption);
        mainLayout = new MelikVerticalLayout();
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
