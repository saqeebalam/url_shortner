package com.test.urlshortner.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.urlshortner.service.UrlMapping;
import com.test.urlshortner.service.UrlService;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService service;
    
    @Value("${app.base.url}")
    private String baseUrl;

    // Create short URL
    @PostMapping("/shorten")
    public ResponseEntity<?> createShortUrl(@RequestParam String url) {
        UrlMapping mapping = service.createShortUrl(url);
        String shortUrl = baseUrl + mapping.getShortCode(); // replace domain when deployed
        return ResponseEntity.ok(shortUrl);
    }

    // Redirect
    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode) {
        Optional<String> originalUrl = service.getOriginalUrl(shortCode);
        if (originalUrl.isPresent()) {
            return ResponseEntity.status(302).location(URI.create(originalUrl.get())).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
