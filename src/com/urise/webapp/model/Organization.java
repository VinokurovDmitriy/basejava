package com.urise.webapp.model;

public class Organization {
    private final String url;
    private final String linkText;
    private final PeriodInfo [] periodsData;

    public Organization(String url, String linkText, PeriodInfo[] periodsData) {
        this.url = url;
        this.linkText = linkText;
        this.periodsData = periodsData;
    }
    public String toString() {
        StringBuilder periods = new StringBuilder();
        for(PeriodInfo period : periodsData) {
            periods.append(period.getDates()).append(" ".repeat(10)).append(period.getTitle())
                    .append("\n\n").append(" ".repeat(27)).append(period.getDescription());
        }
        return linkText + "\n" + periods;
    }
    public static class PeriodInfo {
        private final String dateFrom;
        private final String dateTo;
        private final String title;
        private final String description;

        public PeriodInfo(String dateFrom, String dateTo, String title) {
            this.dateFrom = dateFrom;
            this.dateTo = checkDate(dateTo);
            this.title = title;
            this.description = null;
        }
        public PeriodInfo(String dateFrom, String dateTo, String title, String description) {
            this.dateFrom = dateFrom;
            this.dateTo = checkDate(dateTo);
            this.title = title;
            this.description = description;
        }
        public String getDates() {
            return dateFrom + " - " + dateTo;
        }

        public String getTitle() {
            return title;
        }
        public String getDescription() {
            return description != null ? description : "";
        }
        private String checkDate(String date) {
            return date != null ? date : "сейчас";
        }
    }
}
