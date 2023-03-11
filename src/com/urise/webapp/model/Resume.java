package com.urise.webapp.model;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume>{

    private final String uuid;
    private final String fullName;
    private final Map<SectionType, AbstractSection> sections;
    private final Map<ContactsType, String> contacts;

    public Resume(String fullName, Map<ContactsType, String> contacts, Map<SectionType, AbstractSection> sections) {
        this.contacts = contacts;
        this.fullName = fullName;
        this.sections = sections;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {return uuid;}
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid) && fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public String toString() {
        return fullName + contactsToString() + sectionsToString();
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.getFullName());
        return (cmp == 0) ? uuid.compareTo(o.getUuid()) : cmp;
    }
    private String contactsToString() {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<ContactsType, String> contact : contacts.entrySet()) {
            result.append(contact.getKey().getLabel()).append(contact.getValue()).append("\n");
        }
        return "\n\n" + result;
    }
    private String sectionsToString() {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<SectionType, AbstractSection> sectionEntry : sections.entrySet()) {
            result.append(sectionEntry.getKey().getSectionName()).append("\n\n").append(sectionEntry.getValue()).append("\n\n");
        }
        return "\n\n" + result;
    }
}
