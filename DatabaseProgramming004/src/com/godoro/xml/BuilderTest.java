package com.godoro.xml;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BuilderTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String uri="file:///C:/Users/James/Desktop/Software%20Development/Eclipse%20Luna%20Workspace/XML/src/xmlTest001.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = (Document) builder.parse(uri);
		
		System.out.println("Document: " + document);
		
		Element exam =document.getDocumentElement();
		String id = exam.getAttribute("id");
		System.out.println("Id: " + id);
		
		String title = exam.getElementsByTagName("title").item(0).getTextContent();
		System.out.println("Title: " + title);
		
		NodeList questionList =  exam.getElementsByTagName("questions");
		
		for (int i = 0; i < questionList.getLength(); i++) {
			Element question = (Element) questionList.item(i);
			String number = question.getAttribute("number");
			System.out.println("Number: " + number);
			
			String body = question.getElementsByTagName("body").item(0).getTextContent();
			System.out.println("Body: " + body);
		}
	}
}
