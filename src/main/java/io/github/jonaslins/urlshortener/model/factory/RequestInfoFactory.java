package io.github.jonaslins.urlshortener.model.factory;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestInfoFactory {

    private final static Logger log = LoggerFactory.getLogger(RequestInfoFactory.class);

    public static RequestInfo from(String shortUrlCode,
                                   String ipAddress,
                                   String userAgent,
                                   String referrer) {

        RequestInfo requestInfo = RequestInfo.of(shortUrlCode, ipAddress, userAgent);
        requestInfo.setReferrer(referrer);

        if(userAgent == null || userAgent.isEmpty()) return requestInfo;

        UserAgentAnalyzer uaa = UserAgentAnalyzer
                .newBuilder()
                .withField(UserAgent.AGENT_CLASS)
                .withField(UserAgent.AGENT_NAME)
                .withField(UserAgent.AGENT_VERSION)
                .withField(UserAgent.OPERATING_SYSTEM_CLASS)
                .withField(UserAgent.OPERATING_SYSTEM_NAME)
                .withField(UserAgent.OPERATING_SYSTEM_VERSION)
                .withField(UserAgent.DEVICE_CLASS)
                .withField(UserAgent.DEVICE_NAME)
                .withField(UserAgent.DEVICE_VERSION)
                .build();

        UserAgent userAgentObj = uaa.parse(userAgent);

        requestInfo.setAgentClass(userAgentObj.get(UserAgent.AGENT_CLASS).getValue());
        requestInfo.setAgentName(userAgentObj.get(UserAgent.AGENT_NAME).getValue());
        requestInfo.setAgentVersion(userAgentObj.get(UserAgent.AGENT_VERSION).getValue());
        requestInfo.setOperatingSystemClass(userAgentObj.get(UserAgent.OPERATING_SYSTEM_CLASS).getValue());
        requestInfo.setOperatingSystemName(userAgentObj.get(UserAgent.OPERATING_SYSTEM_NAME).getValue());
        requestInfo.setOperatingSystemVersion(userAgentObj.get(UserAgent.OPERATING_SYSTEM_VERSION).getValue());
        requestInfo.setDeviceClass(userAgentObj.get(UserAgent.DEVICE_CLASS).getValue());
        requestInfo.setDeviceName(userAgentObj.get(UserAgent.DEVICE_NAME).getValue());
        requestInfo.setDeviceBrand(userAgentObj.get(UserAgent.DEVICE_BRAND).getValue());

        return requestInfo;

    }
}
