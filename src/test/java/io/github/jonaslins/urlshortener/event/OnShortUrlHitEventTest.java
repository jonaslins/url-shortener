package io.github.jonaslins.urlshortener.event;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OnShortUrlHitEventTest {

    @Test
    public void shouldInstantiateEvent(){
        String shortUrlCode = "kLPc8a";
        String ipAddress = "192.168.16.1";
        String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11";
        String referrer = "www.foo.bar";

        OnShortUrlHitEvent onShortUrlHitEvent = new OnShortUrlHitEvent(shortUrlCode, ipAddress, userAgent, referrer);

        assertThat(onShortUrlHitEvent.getShortUrlCode()).isEqualTo(shortUrlCode);
        assertThat(onShortUrlHitEvent.getIpAddress()).isEqualTo(ipAddress);
        assertThat(onShortUrlHitEvent.getUserAgent()).isEqualTo(userAgent);
        assertThat(onShortUrlHitEvent.getReferrer()).isEqualTo(referrer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotInstantiateEvent(){
        String shortUrlCode = "";
        String ipAddress = "";
        String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11";
        String referrer = "www.foo.bar";

        OnShortUrlHitEvent onShortUrlHitEvent = new OnShortUrlHitEvent(shortUrlCode, ipAddress, userAgent, referrer);

    }
}