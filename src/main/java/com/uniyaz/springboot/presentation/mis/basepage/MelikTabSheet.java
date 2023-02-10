package com.uniyaz.springboot.presentation.mis.basepage;

import com.uniyaz.springboot.presentation.mis.helper.PageCreator;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

public class MelikTabSheet extends TabSheet {

    public MelikTabSheet() {
        super();
    }

    public void tabEkle(String className, String caption) {
        Component componentWithClassName = PageCreator.createComponentWithClassName(className);
        super.addTab(componentWithClassName, caption);
    }

    public void baseTab(String className) {
        Component componentWithClassName = PageCreator.createComponentWithClassName(className);
        super.setSelectedTab(componentWithClassName);
    }
}
