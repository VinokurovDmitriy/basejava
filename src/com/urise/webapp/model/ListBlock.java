package com.urise.webapp.model;

public class ListBlock {
    private final SectionType header;
    private final String [] textList;
    public ListBlock(SectionType header, String [] textList) {
        this.header = header;
        this.textList = textList;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(String item : textList) {
            result.append('*').append(item).append("\n");
        }
        return "\n" + header.getSectionName() + "\n" + result;
    }
}
