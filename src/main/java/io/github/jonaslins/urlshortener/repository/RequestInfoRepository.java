package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestInfoRepository extends MongoRepository<RequestInfo, String> {

}
