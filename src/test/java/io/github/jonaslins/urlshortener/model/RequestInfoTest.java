package io.github.jonaslins.urlshortener.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestInfoTest {

    @Test
    public void shouldInstantiateRequestInfoFromSingleAgentString() {

        RequestInfo requestInfo =
            RequestInfo.of(
                "1d6as5d1s6a",
                "192.168.1.1",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11");

        //"Mozilla/5.0 (Linux; Android 7.0; Nexus 6 Build/NBD90Z) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.124 Mobile Safari/537.36"

        assertThat(requestInfo.getShortUrlCode()).isEqualTo("1d6as5d1s6a");
        assertThat(requestInfo.getIpAddress()).isEqualTo("192.168.1.1");
        assertThat(requestInfo.getUserAgent()).isEqualTo("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11");
    }
}