package io.github.jonaslins.urlshortener.controller.util;

import javax.servlet.http.HttpServletRequest;

public class RawRequestInfoExtractor {

    private String ipAddress;
    private String userAgent;
    private String referrer;

    private RawRequestInfoExtractor(String ipAddress, String userAgent, String referrer) {
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.referrer = referrer;
    }

    public static RawRequestInfoExtractor from(HttpServletRequest request) {
        return new RawRequestInfoExtractor(
                request.getRemoteAddr(),
                request.getHeader("User-Agent"),
                request.getHeader("referer"));
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
}
