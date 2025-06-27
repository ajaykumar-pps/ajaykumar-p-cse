package com.finance;

import com.reset.util.DBUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getParameter("token");
        String newPassword = request.getParameter("password");

        try (Connection con = DBUtil.getConnection()) {
                PreparedStatement ps = con.prepareStatement("UPDATE users SET password=?, reset_token=NULL, token_expiry=NULL WHERE reset_token=? AND token_expiry>NOW()");
                ps.setString(1, newPassword);
                ps.setString(2, token);
                
                int rows=ps.executeUpdate();
                
                if(rows>0) {
                response.getWriter().write("Password update successful.");
            } else {
                response.getWriter().write("Invalid or expired token.");
            }
        } catch (Exception e) {
        	response.getWriter().write("error "+e.getMessage());
        }
    }
}