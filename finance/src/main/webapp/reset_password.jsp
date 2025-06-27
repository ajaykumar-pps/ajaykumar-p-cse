<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.time.*" %>
<%
    String token = request.getParameter("token");

    if (token == null || token.isEmpty()) {
        out.println("<h3>❌ Invalid reset link.</h3>");
        return;
    }

    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_data", "root", "root");

        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE reset_token=? AND token_expiry > NOW()");
        ps.setString(1, token);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
%>
    <h2>Reset Password</h2>
    <form action="ResetPasswordServlet" method="post">
        <input type="hidden" name="token" value="<%= token %>">
        <label>New Password:</label>
        <input type="password" name="password" required><br><br>
        <button type="submit">Reset Password</button>
    </form>
<%
        } else {
            out.println("<h3>❌ This link has expired or is invalid.</h3>");
        }

    } catch (Exception e) {
        out.println("<h3>Error: " + e.getMessage() + "</h3>");
    } finally {
        if (con != null) con.close();
    }
%>