package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import io.github.jonaslins.urlshortener.model.UrlShorten;

import java.util.Optional;

public interface UrlShortenRepositoryCustom {

    Optional<UrlShorten> findAndModifyByCode(String code, RequestInfo requestInfo);

}
