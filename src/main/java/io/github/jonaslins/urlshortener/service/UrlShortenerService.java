package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.model.UrlShortenStatistics;

public interface UrlShortenerService {

    UrlShorten shortenUrl(String s);

    String getOriginalUrlByCode(String code);

    UrlShortenStatistics getStatisticsByCode(String code);
}
