package com.learning.dom;

import java.io.InputStream;
import java.net.URLConnection;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ReadXMLApi {
    private static final String BCA_API = "https://data.alexa.com/data?cli=10&url=";
    private final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    public static void main(String[] args) {
        ReadXMLApi obj = new ReadXMLApi();
        int bcaRanking = obj.getBcaRanking("bcafinance.co.id");

        System.out.println("Ranking: " + bcaRanking);
    }

    public int getBcaRanking(String domain) {
        int result = 0;

        String url = BCA_API + domain;

        try {
            URLConnection conn = new URL(url).openConnection();

            try (InputStream is = conn.getInputStream()) {
                //
                dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

                DocumentBuilder dBuilder = dbf.newDocumentBuilder();

                Document doc = dBuilder.parse(is);

                Element element = doc.getDocumentElement();

                // find "POPULARITY" tag
                NodeList nodeList = element.getElementsByTagName("POPULARITY");
                if (nodeList.getLength() > 0) {
                    Element elementAttribute = (Element) nodeList.item(0);
                    String ranking = elementAttribute.getAttribute("TEXT");
                    if (!"".equals(ranking)) {
                        result = Integer.parseInt(ranking);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid request for domain: " + domain);
        }
        return result;
    }

}
