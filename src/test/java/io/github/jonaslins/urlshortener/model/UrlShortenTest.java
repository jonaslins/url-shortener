package io.github.jonaslins.urlshortener.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UrlShortenTest {

    @Test
    public void shouldInstantiateUrlShorten() {

        String url = "https://www.linkedin.com/in/jonaslins/";

        UrlShorten urlShorten = new UrlShorten(url);

        assertThat(urlShorten.getOriginalUrl()).isEqualTo(url);
        assertThat(urlShorten.getCode()).isNotNull();
        assertThat(urlShorten.getCode()).hasSize(7);
        assertThat(urlShorten.getHitCount()).isEqualTo(0);
    }
}