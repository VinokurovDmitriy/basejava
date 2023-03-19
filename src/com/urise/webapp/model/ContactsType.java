package com.urise.webapp.model;

public enum ContactsType {

    PHONE("Тел.: "),
    SKYPE("Skype: "),
    EMAIL("Почта: "),
    LINKED_IN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACK_OVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private final String label;

    ContactsType(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
}
