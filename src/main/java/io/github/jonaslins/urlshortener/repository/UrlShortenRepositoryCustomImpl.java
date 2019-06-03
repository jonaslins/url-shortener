package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class UrlShortenRepositoryCustomImpl implements UrlShortenRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<UrlShorten> findAndModifyByCode(String code, RequestInfo requestInfo) {
        Query query = new Query(where("code").is(code));
        Update update = new Update().inc("hitCount", 1).push("requests", requestInfo);
        UrlShorten returned = mongoTemplate.findAndModify(query, update, UrlShorten.class);
        return Optional.of(returned);
    }
}
