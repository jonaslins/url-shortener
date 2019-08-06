package io.github.jonaslins.urlshortener.model;

import io.github.jonaslins.urlshortener.util.RandomShortCodeGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("url_shorten")
public class UrlShorten {

    private static final String BASE_URL = "http://localhost:8080/";

    @Id
    private String id;
    @Indexed(unique = true)
    private String code;
    private String shortLink;
    private String originalUrl;
    @CreatedDate
    private LocalDateTime createdAt;
    private Long hitCount;
    private List<RequestInfo> requests = new ArrayList<>();

    public UrlShorten(String originalUrl) {
        this.originalUrl = originalUrl;
        this.code = RandomShortCodeGenerator.generateCode();
        this.shortLink = BASE_URL + code;
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

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<RequestInfo> getRequests() {
        return requests;
    }

    public String getShortLink() {
        return shortLink;
    }
}
