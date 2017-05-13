package ru.unlimit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("login");
		String password = request.getParameter("pas");
		
		//Map<String, Users> users = (Map<String, Users>)request.getAttribute("users");
		
		Map<String, Users> users = new HashMap<>();
		File f = new File("MyTxt.txt");
		BufferedReader buf = new BufferedReader(new FileReader(f));
		String namem;
	
		
		while ((namem = buf.readLine()) != null){
			users.put(namem, new Users( buf.readLine(), buf.readLine()) );
		}	

		request.getSession().setAttribute("users", users);
		
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if (users.containsKey(name)){
			if (users.get(name).getPas().equals(password)){
				if (users.get(name).getRole().equals("admin")){				
					request.getSession().setAttribute("role", "admin");
					request.getSession().setAttribute("user", name);
					request.getRequestDispatcher("/AdminSite.jsp").forward(request, response);
				//	out.write("hi");
				
				}
				else{
					request.getSession().setAttribute("role", "user");
					
					request.getRequestDispatcher("/UserSite.jsp").forward(request, response);
				}
			}
			else{
				out.write("Пароль введен не верно"+"<html><p><a href=\"LogIn.jsp\">Попробовать снова</a></p></html>");
			}
		}
		else out.write("Пользователь с данным именем не найден"+"<html><p><a href=\"Registration.jsp\">Регистрация</a></p></html>");
	}
}
