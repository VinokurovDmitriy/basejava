package com.urise.webapp.model;

public class BaseInfoBlock {

    private final String header;
    private final String dateFrom;
    private final String dateTo;

    public BaseInfoBlock(String dateFrom, String dateTo, String header) {
        this.header = header;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
    BaseInfoBlock(String dateFrom, String header) {
        this(dateFrom, "Сейчас", header);
    }

    public String getDatesFrom() {
        return dateFrom + " - " + dateTo;
    }
    public String getHeader() {
        return header;
    }

}
