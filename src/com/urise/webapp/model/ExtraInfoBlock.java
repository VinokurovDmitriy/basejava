package com.urise.webapp.model;

public class ExtraInfoBlock extends BaseInfoBlock{
    private final String text;
    public ExtraInfoBlock(String dateFrom, String dateTo, String header, String text) {
        super(dateFrom, dateTo, header);
        this.text = text;
    }
    public ExtraInfoBlock(String dateFrom, String header, String text) {
        super(dateFrom, header);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
