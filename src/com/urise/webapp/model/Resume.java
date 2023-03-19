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
    private Map<SectionType, AbstractSection> sections;
    private Map<ContactsType, String> contacts;

    public Resume(String fullName, Map<ContactsType, String> contacts, Map<SectionType, AbstractSection> sections) {
        this.contacts = contacts;
        this.fullName = fullName;
        this.sections = sections;
        this.uuid = UUID.randomUUID().toString();
    }

    public Resume(String uuid, String fullName) {
        this.fullName = fullName;
        this.uuid = uuid;
        this.contacts = null;
        this.sections = null;
    }

    public Resume(String fullName) {
        this.fullName = fullName;
        this.contacts = null;
        this.sections = null;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {return uuid;}

    public String getFullName() {
        return this.fullName;
    }

    public void setContacts(Map<ContactsType, String> contacts) {
        this.contacts = contacts;
    }

    public void setSections(Map<SectionType, AbstractSection> sections) {
        this.sections = sections;
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
        return fullName + contacts + sections;
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.getFullName());
        return (cmp == 0) ? uuid.compareTo(o.getUuid()) : cmp;
    }
}
