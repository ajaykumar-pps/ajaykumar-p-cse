<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Entry Form</title>
</head>
<body>
<h2>Loan Data Entry</h2>
<form action="Sample_data" method="post">
    <label>Loan ID:</label><br>
    <input type="number" name="loanId" required><br><br>

    <label>Borrower Name:</label><br>
    <input type="text" name="Borrowed_Name" required><br><br>

    <label>Principal Amount:</label><br>
    <input type="number" name="Principle_Amount" step="0.01" required><br><br>

    <label>Interest Rate (% per annum):</label><br>
    <input type="number" name="rate" step="0.01" required><br><br>

    <label>Term (in months):</label><br>
    <input type="number" name="Term_month" required><br><br>

    <label>EMI:</label><br>
    <input type="number" name="Emi" step="0.01" required><br><br>

    <label>Remaining Amount:</label><br>
    <input type="number" name="Remaining_amount" step="0.01" required><br><br>

    <label>Disbursement Date:</label><br>
    <input type="date" name="Disbursement_date" required><br><br>
     <label>Monthly Income:</label><br>
        <input type="number" name="income" step="0.01" required><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
