package com.urise.webapp.model;

public class Link {
    private final String url;
    private final String label;
    public Link(String url, ContactsType label) {
        this.url = url;
        this.label = label.getLabel();
    }
    public Link(String url, String text) {
        this.url = url;
        this.label = text;
    }
    public String getLabel() {
        return label;
    }
}
