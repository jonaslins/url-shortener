package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.event.OnShortUrlHitEvent;
import io.github.jonaslins.urlshortener.exception.ResourceNotFound;
import io.github.jonaslins.urlshortener.model.ShortUrl;
import io.github.jonaslins.urlshortener.model.ShortUrlStatistics;
import io.github.jonaslins.urlshortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlShortenerService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

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

        publishOnShortUrlHitEvent(ipAddress, userAgent, referer, shortUrl);

        return shortUrl.getOriginalUrl();
    }

    private void publishOnShortUrlHitEvent(String ipAddress, String userAgent, String referer, ShortUrl shortUrl) {
        eventPublisher.publishEvent(new OnShortUrlHitEvent(shortUrl.getCode(), ipAddress, userAgent, referer));
    }

    public ShortUrlStatistics getStatisticsByCode(String code) {
        return shortUrlRepository.getStatisticsByCode(code)
                .orElseThrow(ResourceNotFound::new);
    }

    public List<ShortUrl> getAll() {
        return this.shortUrlRepository.findAll();
    }

}
