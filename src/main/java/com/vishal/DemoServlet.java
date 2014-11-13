package com.vishal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpHandler;

import org.json.JSONString;
import org.json.JSONStringer;


/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		response.setHeader("content-type", "application/json");
		contacts.add(new Contact(1L, "Name1", 23, "Phone Number", "Address"));
		contacts.add(new Contact(1L, "Name1", 23, "Phone Number", "Address"));
		contacts.add(new Contact(1L, "Name1", 23, "Phone Number", "Address"));
		response.getWriter().println(getContactListJson(contacts));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private String getContactListJson(List<Contact> contacts) {
	    String returnVal = "";
	    returnVal += "[";
	    for(Contact contact : contacts) {
	        returnVal += getContactAsJson(contact);
	        returnVal += ",";
	    }
	    returnVal += "{}";
	    returnVal += "]";
	    return returnVal;
	}
	
	private String getContactAsJson(Contact contact) {
	    String returnVal = "";
	    returnVal += "{";
	    returnVal +=  getNameValueString("id", "" + contact.getId()) + ",";
	    returnVal += getNameValueString("name", contact.getName()) + ",";
	    returnVal += getNameValueString("address", contact.getAddress()) + ",";
	    returnVal += getNameValueString("age", "" + contact.getAge());
	    returnVal += "}";
	    return returnVal;
	}
	
	private String getNameValueString(String name, String value) {
	    return "\"" + name + "\":\"" + value + "\""; 
	}

}
