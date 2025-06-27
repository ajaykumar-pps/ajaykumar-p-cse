package com.finance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.finance.DAO.Logindao;
import com.finance.model.Loginmodel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username=request.getParameter("username").trim();	
		String password=request.getParameter("password").trim();
		
		
		Loginmodel loginmodel=new Loginmodel(username,password);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_data","root","root");
			
			Logindao dao=new Logindao(con);
			if(dao.validate(loginmodel)) {
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("index.jsp");
			}
			else {
				request.setAttribute("error", "invalid username or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			response.getWriter().println("error"+e.getMessage());
			
		}
		
		
	}

}
