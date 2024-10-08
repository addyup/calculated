package com.cbebank.calculated;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/artist")
public class CbeArtistController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitArtist(@RequestBody Artist artist) {
        if (artist.getName() == null || artist.getEmail() == null) {
            return new ResponseEntity<>("Artist name and email are required.", HttpStatus.BAD_REQUEST);
        }

        // Send email with artist details
        emailService.sendArtistDetails(artist.getName(), artist.getEmail(), artist.getBio());

        return new ResponseEntity<>("Artist details sent successfully!", HttpStatus.OK);
    }
    

    @GetMapping("/a-tm")
    public List<String> scrapeATags() throws IOException {
        return emailService.scrapeAllATags();
    }
    
}