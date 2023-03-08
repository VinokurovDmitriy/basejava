package com.urise.webapp.model;

import java.util.Map;

public class EducationSection {
    private final Map<Link, BaseInfoBlock[]> data;

    public EducationSection(Map<Link, BaseInfoBlock[]> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (var entry : data.entrySet()) {
            BaseInfoBlock[] values = entry.getValue();
            result.append(" ".repeat(10)).append(entry.getKey().getLabel()).append("\n");
            for(var value : values) {
                result.append(value.getDatesFrom()).append(" ".repeat(10)).append(value.getHeader()).append("\n\n");
            }

        }
        return "\n" + SectionType.EDUCATION.getSectionName() + "\n" + result;
    }
}
