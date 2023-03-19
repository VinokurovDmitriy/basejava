package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {

    private final List<Organization> organizationList;

    public OrganizationSection(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Organization o : organizationList) {
            result.append(o);
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationSection that)) return false;
        return getOrganizationList().equals(that.getOrganizationList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrganizationList());
    }
}
