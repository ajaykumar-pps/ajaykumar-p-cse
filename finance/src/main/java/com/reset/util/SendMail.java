package com.reset.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
    public static void send(String to, String subject, String msg) {
        final String from = "ajaykumarpps123@gmail.com";
        final String password = "fhceyhnnmuqqaqzp";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(msg);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}