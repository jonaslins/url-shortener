package io.github.jonaslins.urlshortener.repository;

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

    public Optional<UrlShortenStatistics> getStatisticsByCode(String code) {
        Aggregation agg = newAggregation(
                match(where("code").is(code)), //
                unwind("requests"),
                group(fields("code")
                        .and("shortLink")
                        .and("hitCount")
                        .and("originalUrl")
                        .and("topUserAddress", "requests.IPAddress")).count().as("count")
                ,sort(Sort.Direction.DESC, "count")
        );

        AggregationResults<UrlShortenStatistics> aggregationResults = mongoTemplate.aggregate(
                agg, UrlShorten.class, UrlShortenStatistics.class
        );
        List<UrlShortenStatistics> results = aggregationResults.getMappedResults();

        if(results.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(results.get(0));
    }
}
