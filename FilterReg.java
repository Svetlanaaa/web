package ru.unlimit;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterReg implements Filter {

    public FilterReg() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (httpRequest.getSession().getAttribute("role") == null){
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
		}
		else {
			if (httpRequest.getSession().getAttribute("role").equals("admin")){
				request.getRequestDispatcher("/AdminSite.jsp").forward(request, response);
			} 
			else {
				request.getRequestDispatcher("/UserSite.jsp").forward(request, response);
			}
		}
	
	}	
	

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
