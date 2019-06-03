package io.github.jonaslins.urlshortener.controller;


import io.github.jonaslins.urlshortener.model.UrlShortenStatistics;
import io.github.jonaslins.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/{code}/statistics")
public class UrlShortenerStatisticsController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @GetMapping
    public UrlShortenStatistics redirectToOriginalUrl(@PathVariable String code, HttpServletResponse response) throws IOException {
       return urlShortenerService.getStatisticsByCode(code);
    }
}
