package io.github.jonaslins.urlshortener.controller;


import io.github.jonaslins.urlshortener.controller.request.ShortenUrlRequest;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.model.UrlShortenStatistics;
import io.github.jonaslins.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("/")
    public UrlShorten shortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        UrlShorten urlShorten = urlShortenerService.shortenUrl(shortenUrlRequest.getOriginalUrl());
        return urlShorten;
    }

    @GetMapping("/{code}")
    public ResponseEntity redirectToOriginalUrl(@PathVariable String code, HttpServletResponse response) throws IOException {
        String originalUrl = urlShortenerService.getOriginalUrlByCode(code);
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, originalUrl).build();
    }

    @GetMapping("/{code}/statistics")
    public UrlShortenStatistics getStatistics(@PathVariable String code){
        return urlShortenerService.getStatisticsByCode(code);
    }
}
