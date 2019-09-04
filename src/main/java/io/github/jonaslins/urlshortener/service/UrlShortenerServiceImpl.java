package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.exception.ResourceNotFound;
import io.github.jonaslins.urlshortener.model.RequestInfo;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.model.UrlShortenStatistics;
import io.github.jonaslins.urlshortener.repository.UrlShortenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Autowired
    private UrlShortenRepository urlShortenRepository;


    public UrlShorten shortenUrl(String originalUrl){
        UrlShorten urlShorten = new UrlShorten(originalUrl);
        UrlShorten savedUrlShorten = urlShortenRepository.save(urlShorten);
        return savedUrlShorten;
    }

    public String getOriginalUrlByCode(String code, RequestInfo requestInfo) {
        UrlShorten urlShorten = urlShortenRepository.findAndModifyByCode(code, requestInfo)
                .orElseThrow(ResourceNotFound::new);
        return urlShorten.getOriginalUrl();
    }

    @Override
    public UrlShortenStatistics getStatisticsByCode(String code) {
        return urlShortenRepository.getStatisticsByCode(code)
                .orElseThrow(ResourceNotFound::new);
    }

    @Override
    public List<UrlShorten> getAll() {
        return this.urlShortenRepository.findAll();
    }

}
