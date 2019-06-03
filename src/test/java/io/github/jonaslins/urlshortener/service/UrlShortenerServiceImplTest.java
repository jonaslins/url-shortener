package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.exception.ResourceNotFound;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.repository.UrlShortenRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UrlShortenerServiceImplTest {

    @Mock
    private UrlShortenRepository repository;

    @InjectMocks
    private UrlShortenerServiceImpl service;

    @Test
    public void shortenUrl() {
    }

    @Test
    public void shouldGetOriginalUrlByCode() {
        String originalUrl = "https://www.linkedin.com/in/jonaslins/";
        String code = "kLPc8a";

        UrlShorten urlShorten = new UrlShorten(originalUrl);

        given(repository.findByCode(code)).willReturn(Optional.of(urlShorten));

        String originalUrlByCode = service.getOriginalUrlByCode(code);

        assertThat(originalUrlByCode).isEqualTo("https://www.linkedin.com/in/jonaslins/");
    }

    @Test(expected = ResourceNotFound.class)
    public void shouldThrowResourceNotFoundOnGetOriginalUrlByCode() {
        String originalUrl = "https://www.linkedin.com/in/jonaslins/";
        String code = "kLPc8a";

        UrlShorten urlShorten = new UrlShorten(originalUrl);

        given(repository.findByCode(code)).willReturn(Optional.ofNullable(null));

        String originalUrlByCode = service.getOriginalUrlByCode(code);

    }
}