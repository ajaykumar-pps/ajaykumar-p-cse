package com.finance.DAO;

import java.sql.*;

import com.finance.model.LoanModel;

public class LoanDao {

    private final String URL = "jdbc:mysql://localhost:3306/loan";
    private final String USER = "root";
    private final String PASS = "root";
    private Connection conn;

    public LoanDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertLoan(LoanModel loan) {
        String sql = "INSERT INTO loan_application(name, email, phone, address, loan_amount, loan_type, duration, income, status, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loan.getName());
            ps.setString(2, loan.getEmail());
            ps.setString(3, loan.getPhone());
            ps.setString(4, loan.getAddress());
            ps.setDouble(5, loan.getLoanAmount());
            ps.setString(6, loan.getLoanType());
            ps.setInt(7, loan.getDuration());
            ps.setDouble(8, loan.getIncome());
            ps.setString(9, loan.getStatus());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public LoanModel getLoanById(int id) {
        LoanModel loan = null;
        String sql = "SELECT * FROM loan_application WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    loan = new LoanModel();
                    loan.setId(rs.getInt("id"));
                    loan.setName(rs.getString("name"));
                    loan.setEmail(rs.getString("email"));
                    loan.setPhone(rs.getString("phone"));
                    loan.setAddress(rs.getString("address"));
                    loan.setLoanAmount(rs.getDouble("loan_amount"));
                    loan.setLoanType(rs.getString("loan_type"));
                    loan.setDuration(rs.getInt("duration"));
                    loan.setIncome(rs.getDouble("income"));
                    loan.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loan;
    }

    public boolean updateLoanStatus(int id, String status) {
        String sql = "UPDATE loan_application SET status = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
