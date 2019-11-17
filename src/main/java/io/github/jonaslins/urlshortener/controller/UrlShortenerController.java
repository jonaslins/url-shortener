package io.github.jonaslins.urlshortener.controller;


import io.github.jonaslins.urlshortener.controller.request.ShortenUrlRequest;
import io.github.jonaslins.urlshortener.controller.util.RawRequestInfoExtractor;
import io.github.jonaslins.urlshortener.model.ShortUrl;
import io.github.jonaslins.urlshortener.model.ShortUrlStatistics;
import io.github.jonaslins.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("/")
    public ShortUrl shortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        return urlShortenerService.shortenUrl(shortenUrlRequest.getOriginalUrl());
    }

    @GetMapping("/{code}")
    public ResponseEntity redirectToOriginalUrl(@PathVariable String code,
                                                HttpServletRequest request) throws IOException {

        RawRequestInfoExtractor rawRequestInfoExtractor = RawRequestInfoExtractor.from(request);

        String originalUrl = urlShortenerService.getOriginalUrlByCode(code,
                rawRequestInfoExtractor.getIpAddress(),
                rawRequestInfoExtractor.getUserAgent(),
                rawRequestInfoExtractor.getReferrer());

        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, originalUrl).build();
    }

    @GetMapping("/{code}/statistics")
    public ShortUrlStatistics getStatistics(@PathVariable String code){
        return urlShortenerService.getStatisticsByCode(code);
    }

    @GetMapping("/")
    public List<ShortUrl> getAll() {
       return this.urlShortenerService.getAll();
    }
}
