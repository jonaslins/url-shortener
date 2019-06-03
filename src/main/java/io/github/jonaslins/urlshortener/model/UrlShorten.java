package io.github.jonaslins.urlshortener.model;

import org.apache.commons.lang3.RandomStringUtils;

public class UrlShorten {

    private String originalUrl;
    private String code;
    private Long hitCount;

    public UrlShorten(String originalUrl) {
        this.originalUrl = originalUrl;
        this.code = generateCode();
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

    private String generateCode(){
      return RandomStringUtils.randomAlphanumeric(7);
    }

}
