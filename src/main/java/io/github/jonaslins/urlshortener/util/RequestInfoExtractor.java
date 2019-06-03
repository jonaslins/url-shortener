package io.github.jonaslins.urlshortener.util;

import io.github.jonaslins.urlshortener.model.RequestInfo;

import javax.servlet.http.HttpServletRequest;

public class RequestInfoExtractor {

    public static RequestInfo from(HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        String userAgent = request.getHeader("User-Agent");
        String remoteAddr = request.getRemoteAddr();

        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setReferrer(referrer);
        requestInfo.setOriginalUserAgent(userAgent);
        requestInfo.setIPAddress(remoteAddr);

        return requestInfo;
    }
}
