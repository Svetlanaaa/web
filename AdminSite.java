package ru.unlimit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("login");
		HashMap<String, Users> users = (HashMap<String, Users>)request.getSession().getAttribute("users"); 
		
		users.remove(name);
		
		FileWriter fr  = new FileWriter("myTxt.txt");
	    BufferedWriter br = new BufferedWriter(fr);
	    br.write("");
	               
	    fr  = new FileWriter("myTxt.txt",true);
	    br = new BufferedWriter(fr);
	    for (Map.Entry<String, Users> enty : users.entrySet()){
	    	Users user = enty.getValue();
	    	
	    	br.write(enty.getKey()); br.newLine();
		    br.write(user.getPas()); br.newLine();
		    br.write(user.getRole()); br.newLine();
	    }

	    br.close();
	    fr.close();
	    
	    request.getSession().setAttribute("users", users);
	    request.getRequestDispatcher("/AdminSite.jsp").forward(request, response);
		


}
}