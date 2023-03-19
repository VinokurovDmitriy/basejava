package com.urise.webapp.model;

import java.util.Arrays;
import java.util.Objects;

public class Organization {
    private final String url;
    private final String name;
    private final Period[] periods;

    public Organization(String url, String linkText, Period[] periodsData) {
        this.url = url;
        this.name = linkText;
        this.periods = periodsData;
    }
    public String toString() {
        StringBuilder periods = new StringBuilder();
        for(Period period : this.periods) {
            periods.append(period.getDates()).append(" ".repeat(10)).append(period.getTitle())
                    .append("\n\n").append(" ".repeat(27)).append(period.getDescription());
        }
        return name + "\n" + periods;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public Period[] getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization that)) return false;
        return getUrl().equals(that.getUrl()) && getName().equals(that.getName()) && Arrays.equals(getPeriods(), that.getPeriods());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getUrl(), getName());
        result = 31 * result + Arrays.hashCode(getPeriods());
        return result;
    }

    public static class Period {
        private final String dateFrom;
        private final String dateTo;
        private final String title;
        private final String description;

        public Period(String dateFrom, String dateTo, String title) {
            this.dateFrom = dateFrom;
            this.dateTo = dateTo;
            this.title = title;
            this.description = null;
        }

        public Period(String dateFrom, String dateTo, String title, String description) {
            this.dateFrom = dateFrom;
            this.dateTo = dateTo;
            this.title = title;
            this.description = description;
        }

        public String getDateFrom() {
            return dateFrom;
        }

        public String getDateTo() {
            return dateTo;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description != null ? description : "";
        }

        public String getDates() {
            return dateFrom + " - " + dateTo;
        }

    }
}
