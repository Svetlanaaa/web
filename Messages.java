package ru.unlimit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public volatile List<String> messages = new ArrayList<>();
	
    private void addMessage(String message, String name){
    	message = "[" + name + "]: " + message ;
    	synchronized(this){
    		messages.add(message);
    	}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pOut = response.getWriter();	
		for (String message: messages){
				pOut.print(message + "<br>");	
			}
		pOut.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		String name = (String) request.getSession().getAttribute("user");
		addMessage(message, name);
		getServletConfig().getServletContext().getRequestDispatcher("/GuestBook.jsp").forward(request, response);
	}
}
