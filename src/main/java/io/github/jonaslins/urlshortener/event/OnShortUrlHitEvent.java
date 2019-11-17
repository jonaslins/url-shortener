package io.github.jonaslins.urlshortener.event;

import org.springframework.util.Assert;

import java.util.Objects;

public final class OnShortUrlHitEvent {

    private final String shortUrlCode;
    private final String ipAddress;
    private final String userAgent;
    private final String referrer;

    public OnShortUrlHitEvent(String shortUrlCode, String ipAddress, String userAgent, String referrer) {
        Assert.hasText(shortUrlCode, "The shortUrlCode argument must have text; it must not be null, empty, or blank");
        Assert.hasText(ipAddress, "The ipAddress argument must have text; it must not be null, empty, or blank");
        Assert.hasText(userAgent, "The userAgent argument must have text; it must not be null, empty, or blank");
        this.shortUrlCode = shortUrlCode;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.referrer = referrer;
    }

    public String getShortUrlCode() {
        return shortUrlCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getReferrer() {
        return referrer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnShortUrlHitEvent that = (OnShortUrlHitEvent) o;
        return shortUrlCode.equals(that.shortUrlCode) &&
                ipAddress.equals(that.ipAddress) &&
                userAgent.equals(that.userAgent) &&
                Objects.equals(referrer, that.referrer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortUrlCode, ipAddress, userAgent, referrer);
    }
}
