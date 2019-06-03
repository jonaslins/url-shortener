package io.github.jonaslins.urlshortener.controller;


import io.github.jonaslins.urlshortener.controller.request.ShortenUrlRequest;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping
    public UrlShorten shortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        UrlShorten urlShorten = urlShortenerService.shortenUrl(shortenUrlRequest.getOriginalUrl());
        return urlShorten;
    }
}
