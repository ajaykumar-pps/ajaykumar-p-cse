package com.loan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RepaymentServlet")
public class RepaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loanIdStr = request.getParameter("loanId");
        String repaymentStr = request.getParameter("repaymentAmount");
        String paymentMethod = request.getParameter("paymentMethod");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/loan1";
        String user = "root";
        String pass = "root";

        try {
            int loanId = Integer.parseInt(loanIdStr);
            double repaymentAmount = Double.parseDouble(repaymentStr);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);

            // 1. Get current remaining amount
            String selectSql = "SELECT remaining_amount FROM loans WHERE loan_id = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setInt(1, loanId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                double remaining = rs.getDouble("remaining_amount");
                double newRemaining = remaining - repaymentAmount;

                if (newRemaining < 0) {
                    out.print("<h3>Error: Repayment exceeds remaining amount.</h3>");
                } else {
                    // 2. Update remaining amount in loan
                    String updateSql = "UPDATE loans SET remaining_amount = ? WHERE loan_id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                    updateStmt.setDouble(1, newRemaining);
                    updateStmt.setInt(2, loanId);
                    updateStmt.executeUpdate();

                    // 3. Insert repayment record
                    String insertSql = "INSERT INTO repayments (loan_id, amount_paid, payment_date, payment_method) VALUES (?, ?, CURDATE(), ?)";
                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                    insertStmt.setInt(1, loanId);
                    insertStmt.setDouble(2, repaymentAmount);
                    insertStmt.setString(3, paymentMethod);
                    insertStmt.executeUpdate();

                    out.print("<h3>Repayment successful!</h3>");
                    response.sendRedirect("checkbalance.jsp");
                }
            } else {
                out.print("<h3>Error: Loan ID not found.</h3>");
                response.sendRedirect("repay.jsp");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h3>Exception occurred: " + e.getMessage() + "</h3>");
        }
    }
}
