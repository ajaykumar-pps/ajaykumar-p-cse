<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Loan Repayment</title>
</head>
<body>
    <h2>Loan Repayment Form</h2>
    <form action="RepaymentServlet" method="post">
        <label>Loan ID:</label><br>
        <input type="number" name="loanId" required><br><br>

        <label>Repayment Amount:</label><br>
        <input type="number" name="repaymentAmount" step="0.01" required><br><br>

        <label>Payment Method:</label><br>
        <select name="paymentMethod" required>
            <option value="Cash">Cash</option>
            <option value="UPI">UPI</option>
            <option value="Card">Card</option>
            <option value="Bank Transfer">Bank Transfer</option>
        </select><br><br>

        <input type="submit" value="Submit Repayment">
    </form>
</body>
</html>
    