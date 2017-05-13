package ru.unlimit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("login");
		String password = request.getParameter("pas");
		String role = request.getParameter("role");

		
		Map<String, Users> users = new HashMap<>();
		File f = new File("MyTxt.txt");
		BufferedReader buf = new BufferedReader(new FileReader(f));
		String namem;
	
		
		while ((namem = buf.readLine()) != null){
			users.put(namem, new Users( buf.readLine(), buf.readLine()) );
		}	

		request.getSession().setAttribute("users", users);
		
		
		
		if (users.containsKey(name)){
				out.write("Данное имя уже занято "+"<html><br><p><a href=\"Registration.jsp\">Попробовать снова</a></p></html>");	
				out.close();
				return;
		}
		/*
		File f = new File("MyTxt.txt");
		BufferedReader buf = new BufferedReader(new FileReader(f));
		
		while (f.canRead()){
			String nameUser = buf.readLine();
			buf.readLine();
			buf.readLine();
			
			if (nameUser.equals(name)){
				out.write("Данное имя уже занято "+"<html><br><p><a href=\"Registration.jsp\">Попробовать снова</a></p></html>");	
				out.close();
				buf.close();
				return;
			}
		}
			
			*/
		FileWriter fr = null;
	    BufferedWriter br = null;
	    fr = new FileWriter("myTxt.txt",true);
	    br = new BufferedWriter(fr);
	               
	    br.write(name); br.newLine();
	    br.write(password); br.newLine();
	    br.write(role); br.newLine();
	        
	    br.close();
	    fr.close();
	            
	    out.write(name+", спасибо за регистрацию!"+"<html><br><p><a href=\"LogIn.jsp\">Вход</a></p></html>");	
	    out.close();
		}
}
