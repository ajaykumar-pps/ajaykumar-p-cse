package com.loan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CheckBalanceServlet")
public class CheckBalanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loanIdStr = request.getParameter("loanId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/loan1";
        String user = "root";
        String pass = "root";

        try {
            int loanId = Integer.parseInt(loanIdStr);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT borrower_name, principal, emi, remaining_amount, status FROM loans WHERE loan_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loanId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("borrower_name");
                double principal = rs.getDouble("principal");
                double emi = rs.getDouble("emi");
                double balance = rs.getDouble("remaining_amount");
                String status = rs.getString("status");

                out.println("<h2>Loan Details</h2>");
                out.println("<p><strong>Borrower:</strong> " + name + "</p>");
                out.println("<p><strong>Principal:</strong> ₹" + principal + "</p>");
                out.println("<p><strong>EMI:</strong> ₹" + emi + "</p>");
                out.println("<p><strong>Remaining Balance:</strong> ₹" + balance + "</p>");
                out.println("<p><strong>Status:</strong> " + status + "</p>");
                response.sendRedirect("index.jsp");
            } else {
                out.println("<h3>No loan found with ID: " + loanId + "</h3>");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h3>Exception occurred: " + e.getMessage() + "</h3>");
        }
    }
}
