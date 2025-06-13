package com.br.plurismidia.easymonitor.email.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private JavaMailSender javaMailSender;


    public String sendEmailReport(String recipient, String subject, String messageContent) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(sender);
            helper.setSubject(subject);
            helper.setTo(recipient);

            String template = loadtemplate();
            template = template.replace("#{nome}", recipient);
            template = template.replace("#{message}", messageContent);
            template = template.replace("#{tabelaApisErro}", messageContent);

            helper.setText(template, true);
            javaMailSender.send(mimeMessage);
            return "Email enviado com sucesso!";
        } catch (Exception exception) {
            System.out.println("Falha ao enviar o email: " + exception.getMessage());
            return "Error: " + exception.getLocalizedMessage();
        }
    }

    public String loadtemplate() throws IOException {
        ClassPathResource resource = new ClassPathResource("templates/email/notification.html");
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

}