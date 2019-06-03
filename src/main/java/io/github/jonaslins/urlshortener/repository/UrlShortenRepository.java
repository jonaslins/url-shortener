package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.model.UrlShortenStatistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UrlShortenRepository extends MongoRepository<UrlShorten, String>, UrlShortenRepositoryCustom {

    @Query(value="{ 'code' : ?0 }", fields="{ 'originalUrl' : 1, 'hitCount' : 1}")
    UrlShortenStatistics getStatisticsByCode(String code);
}
