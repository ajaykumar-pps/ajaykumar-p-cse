package com.finance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finance.DAO.RegisterServletDao;
import com.finance.model.Register;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Register register= new Register(name,email,username,password);
		
		try {
            // Load JDBC driver and get DB connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user_data", "root", "root");

            // Create DAO object
            RegisterServletDao dao = new RegisterServletDao(con);

            // Check if user exists
            if (dao.isRegisterExists(email, username)) {
                request.setAttribute("error", " Email or username already exists.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                // Register the user
                if (dao.registerRegister(register)) {
                    response.sendRedirect("login.jsp"); // Success
                } else {
                    request.setAttribute("error", " Registration failed. Try again.");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
		
	}
