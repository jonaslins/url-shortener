package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.ShortUrl;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShortUrlRepository extends MongoRepository<ShortUrl, String>, ShortUrlRepositoryCustom {

}
