package com.loan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewLoanServlet")
public class ViewLoanServlet extends HttpServlet {
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

            String sql = "SELECT * FROM loans WHERE loan_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loanId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h2>Loan Details</h2>");
                out.println("<p><strong>Loan ID:</strong> " + rs.getInt("loan_id") + "</p>");
                out.println("<p><strong>Borrower Name:</strong> " + rs.getString("borrower_name") + "</p>");
                out.println("<p><strong>Principal Amount:</strong> ₹" + rs.getDouble("principal") + "</p>");
                out.println("<p><strong>Interest Rate:</strong> " + rs.getDouble("interest_rate") + "%</p>");
                out.println("<p><strong>Term (Months):</strong> " + rs.getInt("term_months") + "</p>");
                out.println("<p><strong>EMI:</strong> ₹" + rs.getDouble("emi") + "</p>");
                out.println("<p><strong>Remaining Balance:</strong> ₹" + rs.getDouble("remaining_amount") + "</p>");
                out.println("<p><strong>Status:</strong> " + rs.getString("status") + "</p>");
                Date disDate = rs.getDate("disbursement_date");
                out.println("<p><strong>Disbursement Date:</strong> " + (disDate != null ? disDate : "N/A") + "</p>");
            } else {
                out.println("<h3>No loan found with ID: " + loanId + "</h3>");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
