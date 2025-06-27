package com.loan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sample_data")
public class Sample_data extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private double calculateEMI(double principal, double annualRate, int termMonths) {
        double monthlyRate = annualRate / 12 / 100;
        if (monthlyRate == 0) return principal / termMonths;
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, termMonths)) /
                     (Math.pow(1 + monthlyRate, termMonths) - 1);
        return Math.round(emi * 100.0) / 100.0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loanId = request.getParameter("loanId");
        String borrowedName = request.getParameter("Borrowed_Name");
        double principleAmount =Double.parseDouble(request.getParameter("Principle_Amount"));
        String rate = request.getParameter("rate");
        String termMonth = request.getParameter("Term_month");
        String emi = request.getParameter("Emi");
        String remainingAmount = request.getParameter("Remaining_amount");
        String disbursementDate = request.getParameter("Disbursement_date");
        double income = Double.parseDouble(request.getParameter("income"));

        String status;
        if ((principleAmount * 5 > income) && (income > 10000)) {
            status = "Approved";
        } else {
            status = "Rejected";
        }


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String URL = "jdbc:mysql://localhost:3306/loan1";
        String USER = "root";
        String PASS = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            String sql = "INSERT INTO loans (loan_id, borrower_name, principal, interest_rate, term_months, emi, remaining_amount, disbursement_date, income, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(loanId));
            ps.setString(2, borrowedName);
            ps.setDouble(3, principleAmount);
            ps.setDouble(4, Double.parseDouble(rate));
            ps.setInt(5, Integer.parseInt(termMonth));
            ps.setDouble(6, Double.parseDouble(emi));
            ps.setDouble(7, Double.parseDouble(remainingAmount));
            ps.setDate(8, java.sql.Date.valueOf(disbursementDate));
            ps.setDouble(9, income);
            ps.setString(10, "Pending");

            int result = ps.executeUpdate();
            if (result > 0) {
                out.print("<h3>Data inserted successfully!</h3>");
                response.sendRedirect("disburse.html");
            } else {
                out.print("<h3>Failed to insert data.</h3>");
                response.sendRedirect("sample data.jsp");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h3>Exception occurred: " + e.getMessage() + "</h3>");
        }
    }
}
