package com.loan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DisburseLoanServlet")
public class DisburseLoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loanIdStr = request.getParameter("loanId");
        String disbursementDate = request.getParameter("disbursementDate");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/loan1";
        String user = "root";
        String pass = "root";

        try {
            int loanId = Integer.parseInt(loanIdStr);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);

            // Check if loan exists and is not already disbursed
            String checkSql = "SELECT status FROM loans WHERE loan_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, loanId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String status = rs.getString("status");
                if ("Disbursed".equalsIgnoreCase(status)) {
                    out.println("<h3>Loan has already been disbursed.</h3>");
                } else {
                    // Update disbursement info
                    String updateSql = "UPDATE loans SET disbursement_date = ?, status = 'Disbursed' WHERE loan_id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                    updateStmt.setDate(1, java.sql.Date.valueOf(disbursementDate));
                    updateStmt.setInt(2, loanId);
                    updateStmt.executeUpdate();

                    out.println("<h3>Loan successfully disbursed!</h3>");
                    response.sendRedirect("view_loan.jsp");
                }
            } else {
                out.println("<h3>No loan found with ID: " + loanId + "</h3>");
                response.sendRedirect("disburse.html");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
