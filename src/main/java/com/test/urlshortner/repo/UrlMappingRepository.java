package com.test.urlshortner.repo;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.urlshortner.service.UrlMapping;

import java.util.Optional;

public interface UrlMappingRepository extends MongoRepository<UrlMapping, String> {
    Optional<UrlMapping> findByShortCode(String shortCode);
}
