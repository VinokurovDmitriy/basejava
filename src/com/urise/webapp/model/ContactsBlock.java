package com.urise.webapp.model;

public class ContactsBlock {
    private final String phone;
    private final String skype;
    private final String email;
    private final String linkedIn;
    private final String gitHub;
    private final String stackoverflow;
    private final String homePage;

    public ContactsBlock(String phone, Link skype, Link email, Link linkedIn, Link gitHub, Link stackoverflow, Link homePage) {
        this.phone = ContactsType.PHONE + phone;
        this.skype = ContactsType.SKYPE + skype.getText();
        this.email = ContactsType.EMAIL + email.getText();
        this.linkedIn = linkedIn.getText();
        this.gitHub = gitHub.getText();
        this.stackoverflow = stackoverflow.getText();
        this.homePage = homePage.getText();
    }

    public String [] getContacts() {
        return new String[]{phone, skype, email, linkedIn, gitHub, stackoverflow, homePage};
    }
}
