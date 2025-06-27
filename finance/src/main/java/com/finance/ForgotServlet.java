package com.finance;

import com.reset.util.DBUtil;
import com.reset.util.SendMail;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.UUID;

@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        System.out.print("email received in servlet"+email);

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String token = UUID.randomUUID().toString();
                Timestamp expiry = Timestamp.valueOf(LocalDateTime.now().plusMinutes(30));
                PreparedStatement ps2 = con.prepareStatement("UPDATE users SET reset_token=?, token_expiry=? WHERE email=?");
                ps2.setString(1, token);
                ps2.setTimestamp(2, expiry);
                ps2.setString(3, email);
                ps2.executeUpdate();

                String link = "http://localhost:8080/finance/reset_password.jsp?token=" + token;
                System.out.print("Reset link"+link);
                
                String subject ="Reset your Password";
                String msg="Hi, click the link below to reset your password:\n\n"+link+"\n\n This link will expire in 30 muinutes.";
                
                SendMail.send(email,subject,msg);
                response.getWriter().write("Reset link sent to email.");
            } else {
                response.getWriter().write("Email not found.");
            }
        } catch (Exception e) {
        	System.out.println("error in ForgetServlet");
            e.printStackTrace();
            response.getWriter().write("server  error, try again later.");
        }
    }
}