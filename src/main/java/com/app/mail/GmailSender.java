package com.app.mail;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class GmailSender {

    public boolean sendEmail(String from, String to, String subject, String body){
       boolean flag = false;
       String username = "dd7015ddd6db7b";
       String password = "2ca7dc108ec9c5";

//       set the properties....
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port","2525");
        properties.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            flag = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
}
