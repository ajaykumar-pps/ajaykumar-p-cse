<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Forgot Password</title>
  <style>
    body {
      background: #f0f2f5;
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .forgot-box {
      background: #fff;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(0,0,0,0.2);
      width: 350px;
    }
    .forgot-box h2 {
      text-align: center;
      margin-bottom: 20px;
    }
    .forgot-box input[type="email"] {
      width: 100%;
      padding: 12px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 6px;
    }
    .forgot-box button {
      width: 100%;
      padding: 12px;
      background: #007BFF;
      color: white;
      border: none;
      border-radius: 6px;
      cursor: pointer;
    }
    .forgot-box button:hover {
      background: #0056b3;
    }
    .forgot-box .links {
      text-align: center;
      margin-top: 10px;
    }
    .forgot-box .links a {
      text-decoration: none;
      color: #007BFF;
      font-size: 14px;
    }
  </style>
</head>
<body>
<%-- Success/Error Message --%>
  <%
    String msg = (String) request.getAttribute("message");
    if (msg != null) { out.print("<p style='color:green'>" + msg + "</p>"); }
    String err = (String) request.getAttribute("error");
    if (err != null) { out.print("<p style='color:red'>" + err + "</p>"); }
  %>


  <div class="forgot-box">
    <h2>Forgot Password</h2>
    <form action="ForgotServlet" method="post">
      <input type="email" name="email" placeholder="Enter your registered email" required />
      <button type="submit">Submit</button>

      <div class="links">
        <a href="login.jsp">Back to Login</a>
      </div>
    </form>
  </div>

</body>
</html>