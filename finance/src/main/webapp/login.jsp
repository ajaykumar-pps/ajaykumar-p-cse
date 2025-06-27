<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login Form</title>
  <style>
    body {
      background: #f0f2f5;
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .login-box {
      background: #fff;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(0,0,0,0.2);
      width: 300px;
    }
    .login-box h2 {
      text-align: center;
      margin-bottom: 20px;
    }
    .login-box input[type="text"],
    .login-box input[type="password"] {
      width: 100%;
      padding: 12px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 6px;
    }
    .login-box button {
      width: 100%;
      padding: 12px;
      background: #007BFF;
      color: white;
      border: none;
      border-radius: 6px;
      cursor: pointer;
    }
    .login-box button:hover {
      background: #0056b3;
    }
    
    
    .login-box .link{
    margin-top:15px;
    text-align:center;
    }
    .login-box .link a{
    display:block;
    margin:5px 0;
    color:#007BFF;
    text-decoration:none;
    fontt-size:14px;
    
    }
    
    .login-box .link a:hover{
    text-decoration:underline;
    }
    
  </style>
</head>
<body>

<% String error = (String) request.getAttribute("error");
     if (error != null) { %>
    <p style="color:red;"><%= error %></p>
  <% } %>

  <div class="login-box">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
      <input type="text" name="username" placeholder="Username" required />
      <input type="password" name="password" placeholder="Password" required />
      <button type="submit">Login</button>
      
      <div class="link">
       <a href="forgot.jsp">Forgot Password?</a>
      <a href="register.jsp">Create an Account</a>
     
      </div>
    </form>
  </div>
</body>
</html>