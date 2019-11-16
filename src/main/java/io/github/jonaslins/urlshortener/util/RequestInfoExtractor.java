package io.github.jonaslins.urlshortener.util;

import io.github.jonaslins.urlshortener.model.RequestInfo;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class RequestInfoExtractor {

    final static Logger log = LoggerFactory.getLogger(RequestInfoExtractor.class);

    public static RequestInfo from(HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        String userAgent = request.getHeader("User-Agent");
        String remoteAddr = request.getRemoteAddr();

        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setReferrer(referrer);
        requestInfo.setOriginalUserAgent(userAgent);
        requestInfo.setIPAddress(remoteAddr);

       if(userAgent!=null && !userAgent.isEmpty()){
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

            UserAgent capabilities = uaa.parse(userAgent);
            requestInfo.setAgentClass(capabilities.get(UserAgent.AGENT_CLASS).getValue());
            requestInfo.setAgentName(capabilities.get(UserAgent.AGENT_NAME).getValue());
            requestInfo.setAgentVersion(capabilities.get(UserAgent.AGENT_VERSION).getValue());
            requestInfo.setOperatingSystemClass(capabilities.get(UserAgent.OPERATING_SYSTEM_CLASS).getValue());
            requestInfo.setOperatingSystemName(capabilities.get(UserAgent.OPERATING_SYSTEM_NAME).getValue());
            requestInfo.setOperatingSystemVersion(capabilities.get(UserAgent.OPERATING_SYSTEM_VERSION).getValue());
            requestInfo.setDeviceClass(capabilities.get(UserAgent.DEVICE_CLASS).getValue());
            requestInfo.setDeviceName(capabilities.get(UserAgent.DEVICE_NAME).getValue());
            requestInfo.setDeviceBrand(capabilities.get(UserAgent.DEVICE_BRAND).getValue());

        }

        return requestInfo;
    }
}
