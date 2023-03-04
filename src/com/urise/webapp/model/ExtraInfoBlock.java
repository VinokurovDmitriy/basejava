package com.urise.webapp.model;

public class ExtraInfoBlock extends BaseInfoBlock{
    private final String text;
    public ExtraInfoBlock(String dateFrom, String dateTo, String header, String link, String text) {
        super(dateFrom, dateTo, link, header);
        this.text = text;
    }
    public ExtraInfoBlock(String dateFrom, String header, String link, String text) {
        super(dateFrom, link, header);
        this.text = text;
    }

}
