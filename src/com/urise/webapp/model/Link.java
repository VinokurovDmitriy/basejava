package com.urise.webapp.model;

public class Link {
    private final String url;
    private final String text;
    public Link(String url, ContactsType label) {
        this.url = url;
        this.text = label.getLabel();
    }
    public Link(String url, String text) {
        this.url = url;
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
}
