package io.github.jonaslins.urlshortener.model;

import io.github.jonaslins.urlshortener.util.RandomShortCodeGenerator;

public class UrlShorten {

    private String originalUrl;
    private String code;
    private Long hitCount;

    public UrlShorten(String originalUrl) {
        this.originalUrl = originalUrl;
        this.code = RandomShortCodeGenerator.generateCode();
        this.hitCount = 0l;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getCode() {
        return code;
    }

    public Long getHitCount() {
        return hitCount;
    }

}
