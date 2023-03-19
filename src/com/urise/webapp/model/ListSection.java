package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

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

    public Object getSection(Object key) {
        return section.get((int) key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListSection that)) return false;
        return section.equals(that.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section);
    }
}
