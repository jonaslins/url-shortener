package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import io.github.jonaslins.urlshortener.repository.RequestInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RequestInfoServiceTest {

    @InjectMocks
    private RequestInfoService requestInfoService;

    @Mock
    private RequestInfoRepository requestInfoRepository;

    @Test
    public void shouldSaveRequestInfo(){
        String shortUrlCode = "kLPc8a";
        String ip = "192.168.16.1";
        String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11";
        String referrer = "www.foo.bar";

        RequestInfo requestInfo = requestInfoService.saveRequestInfo(shortUrlCode, ip, userAgent, referrer);

        verify(requestInfoRepository, times(1)).save(any());

    }
}