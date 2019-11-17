package io.github.jonaslins.urlshortener.service;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import io.github.jonaslins.urlshortener.model.factory.RequestInfoFactory;
import io.github.jonaslins.urlshortener.repository.RequestInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestInfoService {

    private RequestInfoRepository requestInfoRepository;

    public RequestInfo saveRequestInfo(String shortUrlCode, String ipAddress, String userAgent, String referrer) {
        return requestInfoRepository.save(RequestInfoFactory.from(shortUrlCode, ipAddress, userAgent, referrer));
    }
}
