package io.github.jonaslins.urlshortener.model;

public class UrlShortenStatistics {

    private String originalUrl;
    private String shortLink;
    private String code;
    private Long hitCount;
    private String topUserAddress;

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

    public String getTopUserAddress() {
        return topUserAddress;
    }

    public void setTopUserAddress(String topUserAddress) {
        this.topUserAddress = topUserAddress;
    }

    public String getShortLink() {
        return shortLink;
    }

    public String getCode() {
        return code;
    }
}
