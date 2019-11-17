package io.github.jonaslins.urlshortener.controller.request;

import javax.validation.constraints.NotBlank;

public class ShortenUrlRequest {

    @NotBlank
    private String originalUrl;

    private ShortenUrlRequest(){
    }

    public ShortenUrlRequest(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
