package com.test.urlshortner.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.urlshortner.repo.UrlMappingRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlMappingRepository repo;

    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random random = new Random();

    // Generate short code
    private String generateShortCode(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
        }
        return sb.toString();
    }

    public UrlMapping createShortUrl(String originalUrl) {
        String code;
        do {
            code = generateShortCode(7);
        } while (repo.findByShortCode(code).isPresent());

        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(originalUrl);
        mapping.setShortCode(code);
        mapping.setCreatedAt(Instant.now());
        return repo.save(mapping);
    }

    public Optional<String> getOriginalUrl(String shortCode) {
        Optional<UrlMapping> mapping = repo.findByShortCode(shortCode);
        mapping.ifPresent(m -> {
            m.setClickCount(m.getClickCount() + 1);
            repo.save(m);
        });
        return mapping.map(UrlMapping::getOriginalUrl);
    }
}
