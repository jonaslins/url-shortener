package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.model.UrlShortenStatistics;

import java.util.List;

public interface UrlShortenerService {

    UrlShorten shortenUrl(String s);

    String getOriginalUrlByCode(String code, RequestInfo requestInfo);

    UrlShortenStatistics getStatisticsByCode(String code);

    List<UrlShorten> getAll();
}
