package io.github.jonaslins.urlshortener.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortUrlTest {

    @Test
    public void shouldInstantiateUrlShorten() {

        String url = "https://www.linkedin.com/in/jonaslins/";

        ShortUrl shortUrl = new ShortUrl(url);

        assertThat(shortUrl.getOriginalUrl()).isEqualTo(url);
        assertThat(shortUrl.getCode()).isNotNull();
        assertThat(shortUrl.getCode()).hasSize(7);
        assertThat(shortUrl.getHitCount()).isEqualTo(0);
    }
}