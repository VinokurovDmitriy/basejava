package com.urise.webapp.model;

public class TextBlock {
    private final SectionType header;
    private final String text;
    public TextBlock(SectionType header, String text) {
        this.header = header;
        this.text = text;
    }
    public String toString() {
        return "\n" + this.header.getSectionName() + "\n" + this.text + header + "\n";
    }
}
