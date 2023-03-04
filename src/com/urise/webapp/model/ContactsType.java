package com.urise.webapp.model;

public enum ContactsType {
    PHONE("Тел.: "),
    SKYPE("Skype: "),
    EMAIL("Почта:"),
    LINKED_IN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACK_OVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private String label;
    ContactsType(String s) {
        this.label = s;
    }
}
