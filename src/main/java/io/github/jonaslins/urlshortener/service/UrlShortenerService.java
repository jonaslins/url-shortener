package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.exception.ResourceNotFound;
import io.github.jonaslins.urlshortener.model.ShortUrl;
import io.github.jonaslins.urlshortener.model.ShortUrlStatistics;
import io.github.jonaslins.urlshortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlShortenerService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    public ShortUrl shortenUrl(String originalUrl){
        ShortUrl shortUrl = new ShortUrl(originalUrl);
        ShortUrl savedShortUrl = shortUrlRepository.save(shortUrl);
        return savedShortUrl;
    }

    public String getOriginalUrlByCode(String code,
                                       String ipAddress,
                                       String userAgent,
                                       String referer) {

        ShortUrl shortUrl = shortUrlRepository
                .findAndIncrementHitCount(code)
                .orElseThrow(ResourceNotFound::new);

        return shortUrl.getOriginalUrl();
    }

    public ShortUrlStatistics getStatisticsByCode(String code) {
        return shortUrlRepository.getStatisticsByCode(code)
                .orElseThrow(ResourceNotFound::new);
    }

    public List<ShortUrl> getAll() {
        return this.shortUrlRepository.findAll();
    }

}
