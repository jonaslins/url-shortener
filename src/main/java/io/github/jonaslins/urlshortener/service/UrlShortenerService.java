package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.model.UrlShorten;

public interface UrlShortenerService {

    UrlShorten shortenUrl(String s);

}
