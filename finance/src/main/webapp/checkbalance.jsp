<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Check Loan Balance</title>
</head>
<body>
    <h2>Check Loan Balance</h2>
    <form action="CheckBalanceServlet" method="post">
        <label>Enter Loan ID:</label><br>
        <input type="number" name="loanId" required><br><br>
        <input type="submit" value="Check Balance">
    </form>
</body>
</html>
    