package com.urise.webapp.model;

public class TextBlock {
    private final SectionType header;
    private final String text;
    public TextBlock(SectionType header, String text) {
        this.header = header;
        this.text = text;
    }
    public String printBlock() {
        return "\n" + this.header + "\n" + this.text + header + "\n";
    }
}
