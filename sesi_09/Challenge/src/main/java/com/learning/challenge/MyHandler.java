package com.learning.challenge;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

    private List<UserChallenge> usersChallenge = new ArrayList<>();
    private UserChallenge userChallenge;

    private boolean abc = false;
    private boolean abd = false;

    @Override
    public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
        if ("user".equals(qName)) {
            userChallenge = new UserChallenge();
            int id = Integer.valueOf(attributes.getValue("id"));
            userChallenge.setId(id);
        }
        switch (qName) {
            case "firstname":
                abc = true;
                break;
            case "lastname":
                abd = true;
                break;

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (abc) {
            userChallenge.setFirstName(new String(ch, start, length));
            abc = false;
        }
        if (abd) {
            userChallenge.setLastName(new String(ch, start, length));
            abd = false;
        }
    }

    @Override
    public void endElement(String url, String localName, String qName) throws SAXException {
        if ("user".equals(qName)) {
            usersChallenge.add(userChallenge);
        }
    }

    public List<UserChallenge> getUsersChallenges() {
        return usersChallenge;
    }

}
