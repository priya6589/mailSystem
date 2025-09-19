package com.app.mail;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Properties;

public class GmailSender {

    public boolean sendEmail(String from, String to, String subject, String body, File file){
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
           // message.setText(body);

            MimeBodyPart text = new MimeBodyPart();
            text.setText(body);

            MimeBodyPart attachedFile = new MimeBodyPart();
            attachedFile.attachFile(file);

            MimeMultipart textAttachedFile = new MimeMultipart();
            textAttachedFile.addBodyPart(text);
            textAttachedFile.addBodyPart(attachedFile);

            message.setContent(textAttachedFile);

            Transport.send(message);
            flag = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
}
