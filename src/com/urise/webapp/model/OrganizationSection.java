package com.urise.webapp.model;

import java.util.List;

public class OrganizationSection extends AbstractSection {

    private final List<Organization> organizationList;

    public OrganizationSection(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    @Override
    public Object getElement(Object key) {
        return organizationList.get((int) key);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Organization o : organizationList) {
            result.append(o);
        }
        return result.toString();
    }

}
