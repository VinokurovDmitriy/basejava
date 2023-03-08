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
        this.phone = ContactsType.PHONE.getLabel() + phone;
        this.skype = ContactsType.SKYPE.getLabel() + skype.getLabel();
        this.email = ContactsType.EMAIL.getLabel() + email.getLabel();
        this.linkedIn = linkedIn.getLabel();
        this.gitHub = gitHub.getLabel();
        this.stackoverflow = stackoverflow.getLabel();
        this.homePage = homePage.getLabel();
    }

    public String [] getContacts() {
        return new String[]{phone, skype, email, linkedIn, gitHub, stackoverflow, homePage};
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(String contact : getContacts()) {
            result.append(contact).append("\n");
        }
        return "\n" + result;
    }
}
