package com.urise.webapp.model;

import java.util.Map;

public class ExperienceSection {

    private final Map<Link, ExtraInfoBlock> data;

    public ExperienceSection(Map<Link, ExtraInfoBlock> experienceData) {
        this.data = experienceData;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (var entry : data.entrySet()) {
            var values = entry.getValue();
            result.append(" ".repeat(10)).append(entry.getKey().getLabel()).append("\n");
            result.append(values.getDatesFrom()).append(" ".repeat(10)).append(values.getHeader()).append("\n\n");
            result.append(values.getText()).append("\n\n");
        }
        return "\n" + SectionType.EXPERIENCE.getSectionName() + "\n" + result;
    }
}
