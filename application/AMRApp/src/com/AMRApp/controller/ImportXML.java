package com.AMRApp.utility;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImportXML {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("\\d{10}", Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public static boolean validatePhone(String phone) {
		Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(phone);
		return matcher.find();
	}

	public static void main(File file) {
		try {
			// creating a constructor of file class and parsing an XML file
			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("user");
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String userName = eElement.getElementsByTagName("name").item(0).getTextContent();
					String userEmail = eElement.getElementsByTagName("email").item(0).getTextContent();

					if (!validateEmail(userEmail)) {
						System.out.println("Invalid email");
					}

					String userPhone = eElement.getElementsByTagName("phone").item(0).getTextContent();
					if (!validatePhone(userPhone)) {
						System.out.println("Invalid Phone number");
					}
					String userRole = eElement.getElementsByTagName("role").item(0).getTextContent();
					int credits;
					if(userRole.equals("Manager") ){
						credits=2000;
					}
					else if(userRole.equals("Admin")||userRole.equals("Member")) {
						credits=0;
					}
					else {
						System.out.println("Invalid USer type");
					}
					//DAO insert code here
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
