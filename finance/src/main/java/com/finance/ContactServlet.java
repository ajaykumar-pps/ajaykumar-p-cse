package com.finance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Replace with your Gmail and generated app password
    private final String senderEmail = "ajaykumarpps123@gmail.com";       // Your Gmail
    private final String senderPassword = "fhceyhnnmuqqaqzp";        // App password, not regular password

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form input
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String messageContent = request.getParameter("message");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Validate the email
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();

            // Email server properties
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // Authenticate and create session
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, senderPassword);
                }
            });

            // Compose the message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(senderEmail));
            message.setSubject("New Contact Form Submission from " + name);
            message.setText("Name: " + name + "\nEmail: " + email + "\n\nMessage:\n" + messageContent);

            // Send the email
            Transport.send(message);

            out.println("<h3>Thank you, " + name + "! Your message has been sent successfully.</h3>");
        } catch (AddressException e) {
            out.println("<h3>Invalid email address: " + email + "</h3>");
        } catch (MessagingException e) {
            e.printStackTrace();
            out.println("<h3>Error sending email: " + e.getMessage() + "</h3>");
        }
    }
}
