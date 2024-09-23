package com.sit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sit.entity.User;
import com.sit.repository.Repository;
import com.sit.repositoryIMPL.RepositoryIMPL;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	Repository repository = new RepositoryIMPL();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("email");
	     String password = request.getParameter("pass");
	     
	  // Validation
	        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
	            request.setAttribute("errorMessage", "Username or Password cannot be empty.");
	            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	            rd.forward(request, response);
	            return;
	        }
	        // Authenticate user with database
	        User user = repository.authenticateUser(username, password);
	        
	        if (user != null) {
	            // Successful login
	            request.setAttribute("user", user);
	            RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
	            rd.forward(request, response);
	        } else {
	            // Invalid credentials
	            request.setAttribute("errorMessage", "Invalid Username or Password. Please try again.");
	            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	            rd.forward(request, response);
	        }
	}

}
