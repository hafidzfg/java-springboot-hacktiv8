package com.learning.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseKnownXMLStructure {
    public static void main(String[] args) throws Exception {
        // get document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // build document
        Document document = builder.parse(new File("src/main/resources/employees.xml"));

        // Normalize the XML structure
        document.getDocumentElement().normalize();

        // root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        // get all employees
        NodeList nList = document.getElementsByTagName("employee");
        System.out.println("=======================");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println(""); // as separator
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // print each employee's detail
                Element eElement = (Element) node;
                System.out.println("Employee id: " + eElement.getAttribute("id"));
                System.out
                        .println("First name: " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                System.out.println("Last name: " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                System.out.println("Location: " + eElement.getElementsByTagName("location").item(0).getTextContent());
            }
        }
    }
}
