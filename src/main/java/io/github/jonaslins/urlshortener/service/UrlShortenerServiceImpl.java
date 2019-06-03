package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.exception.ResourceNotFound;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.repository.UrlShortenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Autowired
    private UrlShortenRepository urlShortenRepository;


    public UrlShorten shortenUrl(String originalUrl){
        UrlShorten urlShorten = new UrlShorten(originalUrl);
        UrlShorten savedUrlShorten = urlShortenRepository.save(urlShorten);
        return savedUrlShorten;
    }

    public String getOriginalUrlByCode(String code) {
        UrlShorten urlShorten = urlShortenRepository.findByCode(code)
                .orElseThrow(ResourceNotFound::new);
        return urlShorten.getOriginalUrl();
    }
}
