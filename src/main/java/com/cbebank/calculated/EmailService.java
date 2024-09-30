package com.cbebank.calculated;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendArtistDetails(String name, String email, String bio) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("adwait.uprety@gmail.com");
        message.setSubject("New Artist Submission: " + name);
        message.setText("Artist Name: " + name + "\nEmail: " + email + "\nBio: " + bio);

        mailSender.send(message);
    }
}