package io.github.jonaslins.urlshortener.util;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import io.github.jonaslins.urlshortener.model.RequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
            try {
                UserAgentParser parser = new UserAgentService().loadParser();
                Capabilities capabilities = parser.parse(userAgent);
                requestInfo.setBrowser(capabilities.getBrowser());
                requestInfo.setBrowserType(capabilities.getBrowserType());
                requestInfo.setDeviceType(capabilities.getDeviceType());
                requestInfo.setPlatform(capabilities.getPlatform());

            } catch (IOException e) {
                log.warn("Error while instantiating {} ", UserAgentParser.class);
            } catch (ParseException e) {
                log.warn("Error while extracting request");
            }
        }

        return requestInfo;
    }
}
