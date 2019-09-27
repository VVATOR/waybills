package com.gok.waybill.waybillmailservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.util.Properties;


@Slf4j
@RestController
@RequestMapping("/messages")
public class EmailController {


    private final VelocityEngine velocityEngine;

    @Autowired
    public EmailController(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    @Value("${gmail.login}")
    private String username;

    @Value("${gmail.password}")
    private String password;

   /* static {
        Velocity.setProperty("resource.loader", "class");
        Velocity.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init();

    }*/


    @GetMapping("/email")
    public String sendEmail() {


        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("waybill@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("vvator@gmail.com"/*"vvator@gmail.com, to_username_b@yahoo.com"*/)
            );
            message.setSubject("waybill-mail-service");


            VelocityContext context = new VelocityContext();
            context.put("lName", "vikhlaiev");
            context.put("fName", "vitali");

            // Initialize velocity
            VelocityEngine ve = new VelocityEngine();
            ve.init();
            Template template = velocityEngine.getTemplate("mail.vm");
            StringWriter writer = new StringWriter();
            template.merge(context, writer);
            log.info("{}", writer.toString());

            message.setContent(writer.toString(), "text/html");

            //message.setContent(multipart,"text/plain");

            Transport.send(message);

            log.info("Done");

        } catch (MessagingException e) {
            log.error("{}", e.getMessage());
        }

        return "ok";
    }


}




