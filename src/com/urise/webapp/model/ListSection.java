package com.urise.webapp.model;

import java.util.List;

public class ListSection extends AbstractSection {

    private final List<String> section;

    public ListSection(List<String> section) {
        this.section = section;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(String text : section) {
            result.append('*').append(" ".repeat(5)).append(text).append("\n");
        }
        return result.toString();
    }

    @Override
    public Object getElement(Object key) {
        return section.get((int) key);
    }
}
