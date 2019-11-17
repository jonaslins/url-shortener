package io.github.jonaslins.urlshortener.model.factory;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RequestInfoFactoryTest {

    @Test
    public void shouldCreateRequestInfo() {
        String shortUrlCode = "kLPc8a";
        String ipAddress = "192.168.16.1";
        String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11";
        String referrer = "www.foo.bar";

        RequestInfo requestInfo = RequestInfoFactory.from(shortUrlCode, ipAddress, userAgent, referrer);

        assertThat(requestInfo).isNotNull();
        assertThat(requestInfo.getShortUrlCode()).isEqualTo(shortUrlCode);
        assertThat(requestInfo.getUserAgent()).isEqualTo(userAgent);
        assertThat(requestInfo.getIpAddress()).isEqualTo(ipAddress);
        assertThat(requestInfo.getReferrer()).isEqualTo(referrer);
        assertThat(requestInfo.getAgentName()).isEqualTo("Firefox");
        assertThat(requestInfo.getOperatingSystemClass()).isEqualTo("Desktop");
    }
}