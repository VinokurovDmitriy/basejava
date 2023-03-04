package com.urise.webapp.model;

public class Link {
    private String url;
    private String text;
    public Link(String url, ContactsType text) {
        this.url = url;
        this.text = String.valueOf(text);
    }
    public Link(String url, String text) {
        this.url = url;
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
}
