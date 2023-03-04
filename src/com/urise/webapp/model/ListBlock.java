package com.urise.webapp.model;

public class ListBlock {
    private final SectionType header;
    private final String [] textList;
    public ListBlock(SectionType header, String [] textList) {
        this.header = header;
        this.textList = textList;
    }

    public Enum<SectionType> getHeader() {
        return this.header;
    }
    public String [] getTextList() {
        return this.textList;
    }
}
