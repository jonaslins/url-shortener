package io.github.jonaslins.urlshortener.model;

public class UrlShortenStatistics {

    private String originalUrl;
    private Long hitCount;

    public UrlShortenStatistics() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getHitCount() {
        return hitCount;
    }

    public void setHitCount(Long hitCount) {
        this.hitCount = hitCount;
    }
}
