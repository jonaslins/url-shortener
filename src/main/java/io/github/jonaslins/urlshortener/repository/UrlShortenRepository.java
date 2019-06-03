package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.UrlShorten;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlShortenRepository extends MongoRepository<UrlShorten, String> {

    Optional<UrlShorten> findByCode(String code);

}
