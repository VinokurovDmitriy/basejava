package com.urise.webapp.model;

public class BaseInfoBlock {

    private final String header;
    private final String dateFrom;
    private final String dateTo;
    private final String link;

    public BaseInfoBlock(String dateFrom, String dateTo, String link, String header) {
        this.header = header;
        this.link = header;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
    BaseInfoBlock(String dateFrom, String link, String header) {
        this(dateFrom, "Сейчас", link, header);
    }
}
