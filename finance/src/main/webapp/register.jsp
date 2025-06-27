<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Create Account</title>
  <style>
    body {
      background: #f0f2f5;
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .register-box {
      background: #fff;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(0,0,0,0.2);
      width: 350px;
    }
    .register-box h2 {
      text-align: center;
      margin-bottom: 20px;
    }
    .register-box input[type="text"],
    .register-box input[type="email"],
    .register-box input[type="password"] {
      width: 100%;
      padding: 12px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 6px;
    }
    .register-box button {
      width: 100%;
      padding: 12px;
      background: #28a745;
      color: white;
      border: none;
      border-radius: 6px;
      cursor: pointer;
    }
    .register-box button:hover {
      background: #218838;
    }
    .register-box .links {
      text-align: center;
      margin-top: 10px;
    }
    .register-box .links a {
      text-decoration: none;
      color: #007BFF;
      font-size: 14px;
    }
    .register-box .links a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

  <div class="register-box">
    <h2>Create Account</h2>
    <form action="RegisterServlet" method="post">
      <input type="text" name="name" placeholder="Full Name" required />
      <input type="email" name="email" placeholder="Email" required />
      <input type="text" name="username" placeholder="Username" required />
      <input type="password" name="password" id="password" placeholder="Password" required />
<input type="password" name="confirm_password" id="confirm_password" placeholder="Confirm Password" required />
      <button type="submit">Register</button>

      <div class="links">
        <a href="login.jsp">Already have an account? Login</a>
      </div>
    </form>
  </div>


<script>
  function validateForm() {
    var pass = document.getElementById("password").value;
    var cpass = document.getElementById("confirm_password").value;

    if (pass !== cpass) {
      alert("Passwords do not match!");
      return false; // Prevent form submission
    }
    return true;
  }
</script>

</body>
</html>