package com.AMRApp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.AMRApp.beans.User;
import com.AMRApp.dao.ImportUsersServiceDAOImpl;
import com.AMRApp.dao.ImportUsersServiceDAOInterface;

/**
 * Servlet implementation class ImportXMLServlet
 */
@WebServlet("/ImportXMLServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ImportXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("\\d{10}", Pattern.CASE_INSENSITIVE);

	public boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public  boolean validatePhone(String phone) {
		Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(phone);
		return matcher.find();
	}

		ImportUsersServiceDAOInterface importDAO= new ImportUsersServiceDAOImpl();
	public  void parseXML(File file) {
		try {
			// creating a constructor of file class and parsing an XML file
			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("user");
			List<User> listOfUsers = new ArrayList<User>();
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				User user = new User();
				Node node = nodeList.item(itr);
//				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					user.setUserName(eElement.getElementsByTagName("name").item(0).getTextContent());
					user.setUserEmail(eElement.getElementsByTagName("email").item(0).getTextContent());
					user.setUserPass(eElement.getElementsByTagName("password").item(0).getTextContent());

					if (!validateEmail(user.getUserEmail())) {
						System.out.println("Invalid email");
						continue;
					}

					user.setUserPhone(eElement.getElementsByTagName("phone").item(0).getTextContent())  ;
					if (!validatePhone(user.getUserPhone())) {
						System.out.println("Invalid Phone number");
						continue;
					}
					String userRole = eElement.getElementsByTagName("role").item(0).getTextContent();
					int credits;
					if (userRole.equals("Manager")) {
						credits = 2000;
						user.setUserRole(userRole);
					} else if (userRole.equals("Admin") || userRole.equals("Member")) {
						credits = 0;
						user.setUserRole(userRole);
					} else {
						System.out.println("Invalid USer type");
						continue;
					}
					user.setUserCredits(credits);
					listOfUsers.add(user);

				}
			}
			importDAO.importUsers(listOfUsers);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = getServletContext().getRealPath("") + File.separator + "TempXMLFiles";
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists())
			uploadDir.mkdir();
		for (Part part : request.getParts()) {
			part.write(uploadPath + File.separator + "toImport.xml");
		}
		parseXML(new File(uploadPath + File.separator + "toImport.xml"));
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);

	}

}
