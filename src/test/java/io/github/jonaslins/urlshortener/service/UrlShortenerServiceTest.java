package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.event.OnShortUrlHitEvent;
import io.github.jonaslins.urlshortener.exception.ResourceNotFound;
import io.github.jonaslins.urlshortener.model.ShortUrl;
import io.github.jonaslins.urlshortener.repository.ShortUrlRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UrlShortenerServiceTest {

    @Mock
    private ShortUrlRepository repository;
    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private UrlShortenerService service;

    @Test
    public void shortenUrl() {
    }

    @Test
    public void shouldGetOriginalUrlByCode() {
        String originalUrl = "https://www.linkedin.com/in/jonaslins/";
        String code = "kLPc8a";

        ShortUrl shortUrl = new ShortUrl(originalUrl);

        given(repository.findAndIncrementHitCount(code)).willReturn(Optional.of(shortUrl));

        String originalUrlByCode = service.getOriginalUrlByCode(code,
                "192.168.16.1",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11",
                "www.foo.bar");

        assertThat(originalUrlByCode).isEqualTo("https://www.linkedin.com/in/jonaslins/");
        verify(eventPublisher, times(1)).publishEvent(any(OnShortUrlHitEvent.class));
    }

    @Test(expected = ResourceNotFound.class)
    public void shouldThrowResourceNotFoundOnGetOriginalUrlByCode() {
        String code = "kLPc8a";

        given(repository.findAndIncrementHitCount(code)).willReturn(Optional.empty());

        service.getOriginalUrlByCode(code,
                "192.168.16.1",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11",
                "www.foo.bar");

    }

    @Test(expected = ResourceNotFound.class)
    public void shouldThrowResourceNotFoundOnGetStatisticsByCode() {
        String code = "kLPc8a";

        given(repository.getStatisticsByCode(code)).willReturn(Optional.empty());

        service.getStatisticsByCode(code);

    }
}