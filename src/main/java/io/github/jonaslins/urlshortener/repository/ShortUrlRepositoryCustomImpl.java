package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.ShortUrl;
import io.github.jonaslins.urlshortener.model.ShortUrlStatistics;
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

public class ShortUrlRepositoryCustomImpl implements ShortUrlRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<ShortUrl> findAndIncrementHitCount(String code) {
        Query query = new Query(where("code").is(code));
        Update update = new Update().inc("hitCount", 1);
        ShortUrl returned = mongoTemplate.findAndModify(query, update, ShortUrl.class);
        return Optional.ofNullable(returned);
    }

    public Optional<ShortUrlStatistics> getStatisticsByCode(String code) {
        Aggregation agg = newAggregation(
                match(where("code").is(code)), //
                unwind("requests"),
                group(fields("code")
                        .and("shortUrl")
                        .and("hitCount")
                        .and("originalUrl")
                        .and("topUserAddress", "requests.IPAddress")).count().as("count")
                ,sort(Sort.Direction.DESC, "count")
        );

        AggregationResults<ShortUrlStatistics> aggregationResults = mongoTemplate.aggregate(
                agg, ShortUrl.class, ShortUrlStatistics.class
        );
        List<ShortUrlStatistics> results = aggregationResults.getMappedResults();

        if(results.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(results.get(0));
    }
}
