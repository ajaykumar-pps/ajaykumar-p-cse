package com.finance;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finance.DAO.LoanDao;
import com.finance.model.LoanModel;

import javax.mail.Session;



@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 1. Collect data
        LoanModel loan = new LoanModel();
        loan.setName(request.getParameter("name"));
        loan.setEmail(request.getParameter("email"));
        loan.setPhone(request.getParameter("phone"));
        loan.setAddress(request.getParameter("address"));
        loan.setLoanAmount(Double.parseDouble(request.getParameter("loanAmount")));
        loan.setLoanType(request.getParameter("loanType"));
        loan.setDuration(Integer.parseInt(request.getParameter("duration")));
        loan.setIncome(Double.parseDouble(request.getParameter("income")));

        // 2. Auto-approve based on income
        if (loan.getIncome() > 10000 && loan.getIncome() * 5 >= loan.getLoanAmount()) {
            loan.setStatus("Approved");
        } else {
            loan.setStatus("Pending");
        }


        // 3. Save loan
        LoanDao dao = new LoanDao();
        boolean success = dao.insertLoan(loan);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 4. Send email if inserted
        if (success) {
            try {
                sendEmail(
                    loan.getEmail(),
                    "Loan Application Submitted: " + loan.getStatus(),
                    "Dear " + loan.getName() + ",\n\n" +
                    "Thank you for applying for a loan.\n\n" +
                    "Application Details:\n" +
                    "---------------------\n" +
                    "Loan Type: " + loan.getLoanType() + "\n" +
                    "Amount: ₹" + loan.getLoanAmount() + "\n" +
                    "Duration: " + loan.getDuration() + " months\n" +
                    "Monthly Income: ₹" + loan.getIncome() + "\n" +
                    "Status: " + loan.getStatus() + "\n\n" +
                    "You will be notified of further updates.\n\n" +
                    "Regards,\nLoan Approval Team"
                );
            } catch (MessagingException e) {
                e.printStackTrace();
                out.println("<h3>Loan submitted, but email failed.</h3>");
                return;
            }

            out.println("<h3>✅ Loan Application Submitted Successfully! Status: <b>" + loan.getStatus() + "</b></h3>");
        } else {
            out.println("<h3>❌ Failed to submit loan application. Try again.</h3>");
        }
    }

    // 5. Email sender method
    private void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        final String fromEmail = "ajaykumarpps123@gmail.com"; // use app password
        final String password = "fhceyhnnmuqqaqzp";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
    }
}
