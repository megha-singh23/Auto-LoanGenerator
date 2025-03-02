package com.autoloan.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter("/Restriction")
public class Restriction extends HttpFilter implements Filter {
    
   
	public final String PUBLIC_URLS[]= {"/","/LoginServlet","/ApplyLoanServlet","/RegisterServlet"};
	private static final long serialVersionUID = 1L;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		System.out.println("Filter Destroyed...")	;
	}


	
	
}
