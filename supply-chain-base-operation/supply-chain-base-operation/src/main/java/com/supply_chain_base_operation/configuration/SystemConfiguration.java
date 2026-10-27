package com.supply_chain_base_operation.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class SystemConfiguration {

    @Value("${spring.mail.username}")
    public String apiEmailUsername;

    @Value("${spring.mail.password}")
    public String apiEmailPassword;

    public JavaMailSender createJavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", true);
        mailProperties.put("mail.smtp.starttle.enable", true);
        javaMailSender.setJavaMailProperties(mailProperties);
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername(apiEmailUsername);
        javaMailSender.setPassword(apiEmailPassword);
        return javaMailSender;
    }
}
