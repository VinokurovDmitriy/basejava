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
    private final ContactsBlock contacts;
    private final TextBlock personal;
    private final TextBlock objective;
    private final Object achievement;
    private final Object qualifications;
    private final Map<Link, ExtraInfoBlock> experience;
    private final Map<Link, BaseInfoBlock[]> education;

    public Resume(String fullName, ContactsBlock contacts, TextBlock personal, TextBlock objective, Object achievement,
                  Object qualifications, Map<Link, ExtraInfoBlock> experience, Map<Link, BaseInfoBlock[]> education) {
        this.personal = personal;
        this.contacts = contacts;
        this.fullName = fullName;
        this.objective = objective;
        this.achievement = achievement;
        this.qualifications = qualifications;
        this.experience = experience;
        this.education = education;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {return uuid;}
    public String getFullName() {
        return this.fullName;
    }
    public TextBlock getPersonal() {return this.personal;}
    public TextBlock getObjective() {return this.objective;}
    public Object getAchievement() {return this.achievement;}
    public Object getQualifications() {return this.qualifications;}
    public Object getExperience() {return this.experience;}
    public Object getEducation() {return this.education;}

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
        return
//                uuid + '(' +
                fullName
//                        + ')'
                        + "\n" + contacts + personal + objective + achievement +
                qualifications + experience + education;
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.getFullName());
        return (cmp == 0) ? uuid.compareTo(o.getUuid()) : cmp;
    }
}
