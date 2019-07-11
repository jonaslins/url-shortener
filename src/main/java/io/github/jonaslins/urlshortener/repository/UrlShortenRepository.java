package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.UrlShorten;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlShortenRepository extends MongoRepository<UrlShorten, String>, UrlShortenRepositoryCustom {

}
