<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Loan Details</title>
</head>
<body>
    <h2>Search Loan</h2>
    <form action="ViewLoanServlet" method="post">
        <label>Enter Loan ID:</label><br>
        <input type="number" name="loanId" required><br><br>
        <input type="submit" value="View Loan">
    </form>
</body>
</html>
