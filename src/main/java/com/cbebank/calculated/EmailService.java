package com.cbebank.calculated;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

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
    
    public List<String> scrapeAllATags() throws IOException {
        // Connect to the given URL and get the HTML document
        Document document = Jsoup.connect("https://www.ticketmaster.com/").get();

        // Select all <a> tags from the document
        Elements anchorTags = document.select("a");

        List<String> links = new ArrayList<>();

        // Skip the first 21 results
        for (int i = 21; i < anchorTags.size(); i++) {
            Element anchor = anchorTags.get(i);

            String linkText = anchor.text();          // Text within the <a> tag
            String href = anchor.attr("href");        // The link (href attribute)

            // Save the content in a format that suits your needs
            links.add("Text: " + linkText + ", Link: " + href);
        }

        return links;
    }
}