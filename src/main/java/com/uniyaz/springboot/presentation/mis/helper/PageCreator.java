package com.uniyaz.springboot.presentation.mis.helper;

import com.vaadin.ui.Component;

public class PageCreator {

    public static Component createComponentWithClassName(String className) {

        Component page = null;

        try {
            Object instance = Class.forName(className).getDeclaredConstructor().newInstance();
            page = (Component) instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return page;
    }
}
