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

@WebServlet("/register")
public class registerServlet extends HttpServlet {

	Repository repository = new RepositoryIMPL();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String checkbox = request.getParameter("check");

        if (name == null || name.isEmpty()) {
            request.setAttribute("errorMessage", "Name is required.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        if (email == null || email.isEmpty()) {
            request.setAttribute("errorMessage", "Email is required.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        if (pass == null || pass.isEmpty()) {
            request.setAttribute("errorMessage", "Password is required.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        if (repass == null || repass.isEmpty()) {
            request.setAttribute("errorMessage", "Please confirm your password.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        // Check if password and repeat password match
        if (!pass.equals(repass)) {
            request.setAttribute("errorMessage", "Passwords do not match. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        if (checkbox == null || checkbox.isEmpty() || !checkbox.equals("agree")) {
            request.setAttribute("errorMessage", "You must agree to the terms of service.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        // Check if email already exists in the database
        if (repository.checkIfEmailExists(email)) {
            request.setAttribute("errorMessage", "Email already exists. Please use another email.");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        // Register the new user if validation passes
        User user = new User(name, email, pass, repass);
        repository.addStudent(user);
        RequestDispatcher rd = request.getRequestDispatcher("registerSuccess.jsp");
        rd.forward(request, response);
	}

}
