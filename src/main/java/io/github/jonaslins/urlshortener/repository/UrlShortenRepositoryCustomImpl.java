package io.github.jonaslins.urlshortener.repository;

import com.mongodb.BasicDBObject;
import io.github.jonaslins.urlshortener.model.RequestInfo;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.model.UrlShortenStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
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

    public Optional<UrlShortenStatistics> getUrlShortenStatistics(String code) {
        Aggregation agg = newAggregation(
                match(where("code").is(code)), //
                unwind("requests"),
                group("requests.IPAddress").count().as("count").push(
                        new BasicDBObject("originalUrl", "$originalUrl")
                                .append("hitCount", "hitCount")
                                .append("topUserAddress", "$requests.IPAddress")).as("test"),
                sort(Sort.Direction.DESC, "test"),
                out("test")

        );

        AggregationResults<UrlShortenStatistics> results = mongoTemplate.aggregate(
                agg, UrlShorten.class, UrlShortenStatistics.class
        );
        List<UrlShortenStatistics> intCount = results.getMappedResults();
        return Optional.of(intCount.get(0));
    }
}
