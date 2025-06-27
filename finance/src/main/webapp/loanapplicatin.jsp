<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f0f0;
        padding: 30px;
    }

    .form-container {
        background: #fff;
        padding: 30px;
        border-radius: 10px;
        width: 90%;
        max-width: 500px;
        margin: auto;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    input, select, textarea {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    h2 {
        text-align: center;
    }

    @media screen and (max-width: 600px) {
        body {
            padding: 15px;
        }

        .form-container {
            padding: 20px;
        }

        h2 {
            font-size: 20px;
        }
    }
</style>

</head>
<body>
    <div class="form-container">
        <h2>Loan Application Form</h2>
        <form action="LoanServlet" method="post">
            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="phone">Phone Number</label>
            <input type="text" id="phone" name="phone" pattern="\d{10}" maxlength="10" title="Enter a 10-digit phone number" required>

            <label for="address">Address</label>
            <textarea id="address" name="address" required></textarea>

            <label for="loanAmount">Loan Amount</label>
            <input type="number" id="loanAmount" name="loanAmount" min="1000" required>

            <label for="loanType">Loan Type</label>
            <select id="loanType" name="loanType" required>
                <option value="">-- Select Loan Type --</option>
                <option value="Personal">Personal</option>
                <option value="Home">Home</option>
                <option value="Education">Education</option>
                <option value="Business">Business</option>
            </select>
            <label for="duration">Loan Duration (in months)</label>
            <input type="number" id="duration" name="duration" min="1" placeholder="e.g., 12 for 1 year" required>
            
            <label for="income">Monthly Income</label>
            <input type="number" id="income" name="income" min="0" required>
            <input type="submit" value="Apply Now">
        </form>
    </div>
</body>
</html>
